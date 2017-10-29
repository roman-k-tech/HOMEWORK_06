package TASK_05;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Роман on 29.10.2017.
 */
public class Main
{

    public static void main(String[] args)
    {

        Thread fileCheck = new Thread(new Alarm());
        fileCheck.start();

        String input = null;
        Scanner s = new Scanner(System.in);

        boolean exited = false;
        while (!exited)
        {
            System.out.println("\nProgram generates an error each time there is a change in current folder:");
            System.out.println(System.getProperty("user.dir"));
            System.out.println("\nCommands:");
            System.out.println("0 - Stop program");

            input = s.next();

            switch (input.charAt(0))
            {
                case '0':
                    fileCheck.interrupt();
                    exited = true;
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("INVALID COMMAND!");
                    break;
            }
        }
        s.close();
    }
}
