package M5_MVCPattern;
/*
Design Patterns and the Comparator interface:
 Locations:
    -Factory method:       CryptoCurrencyFactory class
    -Builder pattern:      CryptoCurrencyImplementer class / getAnonymousCoin()
    -Strategy pattern:     CryptoCurrencyFactory class / getProgrammableCoin()
    -Comparator interface: CryptoCurrency class / NAME_COMPARATOR
 */

//LOOK ON BOTTOM TO FIND PROFESSOR MASTER'S FEEDBACK!!!!
import java.util.Arrays;

public class CryptoCurrencyImplementer
{
    // M3 USING BUILDER PATTERN
    private static AnonymousCoin getAnonymousCoin()
    {
        AnonymousCoin anonymousCoin = new AnonymousCoin.AnonymousCoinBuilder("HushCoin", 987654321L, 10000000000L)
                .symbol("shh")
                .description("Peer-to-peer anonymous transactions")
                .build();
        return anonymousCoin;
    }

    private static LotteryCoin getLotteryCoin()
    {
        LotteryCoin lotteryCoin = new LotteryCoin("LuckyCoin");
        lotteryCoin.setSymbol("LCK");
        lotteryCoin.setDescription("An international, decentralized, open-source lottery system");
        lotteryCoin.setCirculatingSupply(887777);
        lotteryCoin.setMarketCap(99988888);
        lotteryCoin.setLuckyNumber(1234567);
        return lotteryCoin;
    }
    private static String arrToStr(CryptoCurrency[] cryptoArray)
    {
        String results = "";
        for(int i = 0; i < cryptoArray.length; i++)
        {
            //Used to vertically align the prices
            if(cryptoArray[i].getName().length() >8)
            {
                results += "\t-"+cryptoArray[i].getName()+": "+cryptoArray[i].getPrice()+"\n";
            }
            else
            {
                results += "\t-"+cryptoArray[i].getName()+": \t"+cryptoArray[i].getPrice()+"\n";
            }

        }
        return results;
    }

    private static void beforeAfterSorting(CryptoCurrency[] cryptoArray)
    {
        //M3 COMPARATOR IMPLEMENTED
        System.out.println("Before any sort:");
        System.out.println(arrToStr(cryptoArray));
        System.out.println("Name sort:");
        Arrays.sort(cryptoArray, CryptoCurrency.NAME_COMPARATOR);
        System.out.println(arrToStr(cryptoArray));
    }

    public static void main(String[] args)
    {
        //M3 USING FACTORY METHOD
//        CryptoCurrency usersCoin1 = CryptoCurrencyFactory.getInstance();
//        CryptoCurrency usersCoin2 = CryptoCurrencyFactory.getInstance();
//        AnonymousCoin anonymousCoin = getAnonymousCoin();
//        LotteryCoin lotteryCoin = getLotteryCoin();
//
//        CryptoCurrency[] cryptoArray = { usersCoin1, usersCoin2, anonymousCoin, lotteryCoin };
//
//        System.out.println(CryptoCurrency.getDividingLine());
//        for(CryptoCurrency coin : cryptoArray)
//        {
//            System.out.println(coin);
//        }
//        System.out.println("\nTotal market capitalization: "+CryptoCurrency.getTotalMarketCap()+"\n");
//        beforeAfterSorting(cryptoArray);
//        System.out.println(CryptoCurrency.getDividingLine());
    }
}

/*
BUILDER: looks great!

-1 builder constructor shouldn't take in circulatingSupply
   since it's not used- create a named method for this

MY OPINION: You need to at least have the circulating supply
            to determine the price of the cryptocurrency

COMPARATOR: looks great!

STRATEGY

the interfaces and implementing classes are set up well; so is the object being instance data

-3 to fully implement the strategy pattern,

you need a method in the ProgrammableCoin class

that invokes the getScript method on the Programmable object

FACTORY

good factory method! review the discussion on the practice discussion board about

removing the user interaction (e.g., Scanner object) from your factory method;

you might improve your code by sending in the type and other information as parameters



note: DIVIDING_LINE doesn't have to be private!
constants can be either public or private- either is okay;
it all depends on whether or not you want external classes to access the constant or not
(if i wrote private in my previous feedback,
it was probably just habit-
private final static or public final static are both okay)

overall good job!
 */