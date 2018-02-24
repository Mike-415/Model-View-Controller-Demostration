package M5_MVCPattern;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

//M2 HOMEWORK COMPARABLE INTERFACE IMPLEMENTATION ON ProgrammableCoin.java FILE
public class CryptoCurrency implements Comparable<CryptoCurrency>
{
    //M2 HOMEWORK STATIC VARIABLES

    public static final Comparator<CryptoCurrency> NAME_COMPARATOR = new CryptoCurrencyNameComparator();
    public static final String DEFAULT_STRING = "";
    public static final int DEFAULT_INT = 0;
    public static final long DEFAULT_LONG = 10000000L;
    private static final String DIVIDING_LINE = "\n-----------------------------------------------------------------------------------\n";
    private static long totalMarketCap = 0;
    private boolean singleParameterConstructorCalled = false;
    private CapSize capSize;
    private String name, symbol, description;
    private long circulatingSupply, marketCap;
    private BigDecimal price;

    //M2 HOMEWORK ENUM
    public enum CapSize
    {
        LARGE("Large"), MID("Mid"), SMALL("Small"), MICRO("Micro");
        private String fullName;
        private CapSize(String fullName)
        {
            this.fullName = fullName;
        }
        public String getFullName()
        {
            return fullName;
        }

    }

    //M3 COMPARATOR IMPLEMENTATION
    private static class CryptoCurrencyNameComparator implements Comparator<CryptoCurrency>
    {

        public int compare(CryptoCurrency currency1, CryptoCurrency currency2)
        {
            int firstChar1 = currency1.getName().toLowerCase().charAt(0);
            int firstChar2 = currency2.getName().toLowerCase().charAt(0);
            if(firstChar1 > firstChar2)
            {
                return 1;
            }
            else if(firstChar1 < firstChar2)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }

    public CryptoCurrency(String name)
    {

        this(name, DEFAULT_STRING, DEFAULT_STRING, DEFAULT_INT, DEFAULT_INT);
        singleParameterConstructorCalled = true;
    }

    public CryptoCurrency(String name, String symbol, String description, long circulatingSupply, long marketCap)
    {
        this.name = name;
        this.symbol = symbol;
        this.description = description;
        this.circulatingSupply = circulatingSupply;
        this.marketCap = marketCap;

        //REMINDER: Remember (in your driver class) that you start with the single parameter constructor
        //The other values were filled with the default values.
        //This is why calculating the price in the constructor was erroneous
        //SOLUTION: Use the boolean variable singleParameterConstructorCalled as a flag.
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol.toUpperCase();
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public long getCirculatingSupply()
    {
        return circulatingSupply;
    }

    public void setCirculatingSupply(long circulatingSupply)
    {
        this.circulatingSupply = circulatingSupply;
    }

    public long getMarketCap()
    {
        return marketCap;
    }

    public void setMarketCap(long marketCap)
    {
        this.marketCap = marketCap;
    }

    public CapSize getCapSize()
    {
        return capSize;
    }
    public void calculateCapSize()
    {
        if( getMarketCap()>= 10000000000L)
        {
            capSize = CapSize.LARGE;
        }
        else if(getMarketCap() < 10000000000L && getMarketCap() >= 2000000000)
        {
            capSize = CapSize.MID;
        }
        else if(getMarketCap() < 2000000000 && getMarketCap() >= 250000000)
        {
            capSize = CapSize.SMALL;
        }
        else
        {
            capSize = CapSize.MICRO;
        }
    }

    //M2 HOMEWORK STATIC METHOD
    public static long getTotalMarketCap()
    {
        return totalMarketCap;
    }

    public BigDecimal getPrice()
    {
        if(singleParameterConstructorCalled)
        {
            price = calculatePrice(getMarketCap(), getCirculatingSupply());
        }
        return price;
    }


    public BigDecimal calculatePrice(long marketCap, long circulatingSupply)
    {
        BigDecimal mrkCap = new BigDecimal(Long.toString(marketCap));
        BigDecimal crcSup = new BigDecimal(Long.toString(circulatingSupply));
        return mrkCap.divide(crcSup, 2, RoundingMode.HALF_EVEN);
    }

    public static String getDividingLine()
    {
        return DIVIDING_LINE;
    }

    @Override
    public boolean equals(Object object)
    {
        if(object instanceof CryptoCurrency)
        {
            CryptoCurrency otherCurrency = (CryptoCurrency)object;
            boolean sameName = getName().equalsIgnoreCase(otherCurrency.getName());
            boolean sameSymbol =  getSymbol().equalsIgnoreCase(otherCurrency.getSymbol());
            boolean sameDescription = getDescription().equalsIgnoreCase(otherCurrency.getDescription());
            boolean sameCirculatingSupply = getCirculatingSupply() == otherCurrency.getCirculatingSupply();
            boolean sameMarketCap = getMarketCap() == otherCurrency.getMarketCap();
            return sameName && sameSymbol && sameDescription && sameCirculatingSupply && sameMarketCap;
        }
        return false;
    }

    @Override
    public String toString()
    {
        calculateCapSize();
        CryptoCurrency.totalMarketCap += marketCap;
        String results = "";
        results += "Name:\t\t\t\t"+getName()+"\n";
        results += "Symbol:\t\t\t\t"+getSymbol()+"\n";
        results += "Description:\t\t\t"+getDescription()+"\n";
        results += "Circulating Supply:\t\t"+getCirculatingSupply()+"\n";
        results += "Market Cap:\t\t\t"+getMarketCap()+"\n";
        //M2 HOMEWORK ENUM USE
        results += "Cap size:\t\t\t\t"+getCapSize().getFullName()+"\n";
        results += "Price:\t\t\t\t"+getPrice()+"\n";
        return results;
    }

    @Override
    public int compareTo(CryptoCurrency otherCoin)
    {
        if(this.getPrice().compareTo(otherCoin.getPrice()) < 0 )
        {
            return -1;
        }
        else if(this.getPrice().compareTo(otherCoin.getPrice()) > 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
