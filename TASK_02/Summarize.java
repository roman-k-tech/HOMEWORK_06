package TASK_02;

import java.util.Random;

/**
 * Created by Роман on 28.10.2017.
 */
public class Summarize extends Thread
{
    private Integer[] numbers;

    private Integer startBoundary;
    private Integer endBoundary;

    private Integer summ = 0;
    private Thread thread;

    public Integer getSumm()
    {
        return summ;
    }
    public Thread getThread()
    {
        return thread;
    }

    public Summarize(Integer[] numbers) {
        this.numbers = numbers;

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run()
    {
        for (Integer number : numbers)
        {
            summ += number;
        }
    }
}
