package TASK_01;

/**
 * Created by Роман on 28.10.2017.
 */
public class Main
{
    public static void main(String[] args)
    {

        Thread th = Thread.currentThread();

        Integer i = 100;
        Thread[] threads = new Thread[i];

        for (Integer j = 0; j < threads.length; j++)
        {
            threads[j] = new Thread(new Factorial(j + 1));
            threads[j].setName("THREAD #" + (j + 1));
            threads[j].start();
        }

//		thOne.setDaemon(true);
//		thTwo.setDaemon(true);
//		thThree.setDaemon(true);

//        thOne.start();
//        thTwo.start();
//        thThree.start();

//	try {
//		thOne.join();
//		thTwo.join();
//		thThree.join();
//	}
//	catch(InterruptedException e)
//	{
//		e.printStackTrace();
//	}
//        thOne.interrupt();

        System.out.println(th.getName() + " is Stop");
    }
}
