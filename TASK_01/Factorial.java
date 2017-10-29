package TASK_01;

import java.math.BigInteger;

/**
 * Created by Роман on 28.10.2017.
 */
public class Factorial implements Runnable
{
    private int n;
    Thread th = null;

    public Factorial(int n) {
        this.n = n;
        th = Thread.currentThread();
    }

    public Factorial() {}

    private BigInteger factoialCalculate (int n)
    {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++)
        {
            if (th.isInterrupted())
            {
                System.out.println(th.getName() + " STOP");
                break;
            }
            fact = fact.multiply(new BigInteger("" + i));
        }
        return fact;
    }

    @Override
    public void run()
    {
        Thread th = Thread.currentThread();
//        int i;
//        for (i = 1; i <= this.n; i++)
//        {
//            if (th.isInterrupted())
//            {
//                System.out.println(th.getName() + " STOP");
//                break;
//            }
//        }
        System.out.println(th.getName() + " -> " + this.n + " ! = " + factoialCalculate(this.n));
    }
}
