package M5_MVCPattern;

import java.util.Random;


public class LotteryCoin extends CryptoCurrency
{
    private int luckyNumber;
    public LotteryCoin(String name)
    {
        super(name);
    }

    public LotteryCoin(String name, String symbol, String description, int circulatingSupply, int marketCap)
    {
        super(name, symbol, description, circulatingSupply, marketCap);
        luckyNumber = CryptoCurrency.DEFAULT_INT;
    }

    public void setLuckyNumber(int sevenDigitNumber)
    {
        luckyNumber = sevenDigitNumber;
    }

    public int getLuckyNumber()
    {
        return luckyNumber;
    }

    private int generateRandomNumber()
    {
        Random random = new Random();
        return random.nextInt(9999999)+1000000;
    }

    public String playLotto()
    {
        int lottoNumbers = generateRandomNumber();
        String results = "Results:";
        results += "\n\tYour numbers:\t"+getLuckyNumber();
        results += "\n\tLotto numbers:\t"+lottoNumbers;
        if(getLuckyNumber() == lottoNumbers)
        {
            results += "\n\tYOU WON 2000 BITCOIN!!!!\n";
        }
        else
        {
            results += "\n\tPlease try again.\n";
        }
        return results;
    }

    @Override
    public boolean equals(Object object)
    {
        if(object instanceof LotteryCoin)
        {
            return super.equals(object);
        }
        return false;
    }

    @Override
    public String toString()
    {
        String results = "";
        results += super.toString();
        return results;
    }

}
