package pl.michnamarcin.core;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Action
{
    public static void action(int id)
    {
        try
        {
            int randomNum = ThreadLocalRandom.current().nextInt(5, 50 + 1);
            TimeUnit.SECONDS.sleep(randomNum);
            QueueHandler q = new QueueHandler();
            q.send(id);
        }
        catch(Exception e)
        {
            System.out.println("sleep exception");
        }

    }
}
