package M5_MVCPattern;

import java.math.BigDecimal;

//REMEMBER: This class is used to demonstrate the Builder Pattern
public class AnonymousCoin extends CryptoCurrency
{

    //public AnonymousCoin(String name){super(name);}
    private AnonymousCoin(AnonymousCoinBuilder builder)
    {
        //Rationale for using the single-parameter constructor:
        //   The price needs to be set, and this is done programatically
        //   with the single-parameter constructor
        super(builder.name);
        this.setSymbol(builder.symbol);
        this.setDescription(builder.description);
        this.setCirculatingSupply(builder.circulatingSupply);
        this.setMarketCap(builder.marketCap);

    }
    public static class AnonymousCoinBuilder
    {
        //Mandatory fields
        private String name;
        private long marketCap;

        //Optional fields
        private String symbol = DEFAULT_STRING, description = DEFAULT_STRING;
        private long circulatingSupply = DEFAULT_LONG;

        public AnonymousCoinBuilder(String name, long marketCap, long circulatingSupply)
        {
            this.name = name;
            this.marketCap = marketCap;
        }
        public AnonymousCoinBuilder symbol(String symbol)
        {
            this.symbol = symbol;
            return this;
        }
        public AnonymousCoinBuilder description(String description)
        {
            this.description = description;
            return this;
        }
        public AnonymousCoin build()
        {
            return new AnonymousCoin(this);
        }

    }//class: CryptoCurrencyBuilder

    public String getHashingAlgoType()
    {
        return "SHA3-256 (quantum-proof)";
    }

    @Override
    public String toString()
    {
        String results = "";
        results += super.toString();
        return results;
    }

    @Override
    public boolean equals(Object object)
    {
        if(object instanceof AnonymousCoin)
        {
            return super.equals(object);
        }
        return false;
    }
}
