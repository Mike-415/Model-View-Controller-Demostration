package M5_MVCPattern;

import java.util.Scanner;

public class CryptoCurrencyFactory
{

    public static CryptoCurrency getInstance(int cryptoCurrencyType)
    {

        CryptoCurrency currency;
        switch (cryptoCurrencyType)
        {
            case 1:
                currency = getProgrammableCoin();
                break;
            case 2:
                currency = getAnonymousCoin();
                break;
            case 3:
                currency = getLotteryCoin();
                break;
            default:
                throw new IllegalArgumentException("You can only enter the numbers 1, 2, or, 3");
        }
        return currency;
    }
    private static ProgrammableCoin getProgrammableCoin()
    {
        //M3 USING STRATEGY
        ProgrammableCoin programmableCoin = new ProgrammableCoin("AdaCoin", new RandomScript());
        programmableCoin.setSymbol("ADA");
        programmableCoin.setDescription("Decentralized applications using block-chain technology");
        programmableCoin.setCirculatingSupply(1000055500);
        programmableCoin.setMarketCap(90000000000L);
        return programmableCoin;
    }

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
}
