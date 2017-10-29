package TASK_05;

import java.io.File;
import java.nio.file.Files;

/**
 * Created by Роман on 29.10.2017.
 */
public class Alarm implements Runnable {

    @Override
    public void run()
    {
        String infolderName = ".";
        File infolder = new File(infolderName);

        if (!infolder.isDirectory())
        {
            System.out.println("ERROR!");
            return;
        }

        File[] fileList = infolder.listFiles();
        while(true)
        {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {return;}

            File[] newFL = infolder.listFiles();

            if (fileList.length == newFL.length)
            {
                for (int i = 0; i < fileList.length; i++)
                {
                    if (!fileList[i].equals(newFL[i]))
                    {
                        System.out.println("STRUCTURE CHANGED!");
                        break;
                    }
                }
            }
            else
            {
                System.out.println("STRUCTURE CHANGED!");
            }
            fileList = newFL;
            if (Thread.interrupted()) {return;}
        }
    }
}
