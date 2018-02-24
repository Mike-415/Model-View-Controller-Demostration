package M5_MVCPattern;

import java.util.Random;

/**
 * Created by Mike-415 on 2/5/18.
 */
public class RandomScript implements Programmable
{
    @Override
    public String getScript()
    {
        Random random = new Random();
        return "Random number generated: \n\t\t\t\t\t"+random.nextInt(100)+1;
    }
}
