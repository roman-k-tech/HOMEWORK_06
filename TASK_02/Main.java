package TASK_02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Роман on 28.10.2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Integer[] numbers = new Integer[100_000];
        Random random = new Random();
        long tstart;
        long tend;
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = random.nextInt(1) + 1;
        }

        Integer[] range_1 = Arrays.copyOfRange(numbers, 0, 25_000);
        Integer[] range_2 = Arrays.copyOfRange(numbers, 25_000, 50_000);
        Integer[] range_3 = Arrays.copyOfRange(numbers, 50_000, 75_000);
        Integer[] range_4 = Arrays.copyOfRange(numbers, 75_000, 100_000);

        tstart = System.currentTimeMillis();

        Summarize summ_1 = new Summarize(range_1);
        Summarize summ_2 = new Summarize(range_2);
        Summarize summ_3 = new Summarize(range_3);
        Summarize summ_4 = new Summarize(range_4);

        try {
            summ_1.getThread().join();
            summ_2.getThread().join();
            summ_3.getThread().join();
            summ_4.getThread().join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        Integer summ = summ_1.getSumm() + summ_2.getSumm() + summ_3.getSumm() + summ_4.getSumm();
        tend = System.currentTimeMillis();
        System.out.println(summ + " - " + (tend - tstart));

        summ = 0;
        tstart = System.currentTimeMillis();
        for (Integer number : numbers)
        {
            summ += number;
        }
        tend = System.currentTimeMillis();
        System.out.println(summ + " - " + (tend - tstart));

    }
}
