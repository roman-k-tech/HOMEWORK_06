package TASK_04;

import java.io.File;

/**
 * Created by Роман on 28.10.2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        String infolderName = ".";
        String outfolderName = ".\\outFolder";

        File infolder = new File(infolderName);
        File outfolder = new File(outfolderName);


        if (infolder.isDirectory())
        {
            File[] filenames = infolder.listFiles();
            if (!outfolder.exists())
            {
                outfolder.mkdir();
            }
            for (File file : filenames)
            {
                if (!file.isDirectory())
                {
                    File outfile = new File(outfolder + "\\" + file.getName());
                    new Thread(new FileCopy(file.toString(), outfile.toString())).start();
                }
            }
        }
        else
        {
            System.out.println("ERROR!");
        }
    }
}
