package TASK_04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Роман on 28.10.2017.
 */
public class FileCopy implements Runnable
{
    private String input;
    private String output;
    private Thread thread;

    public FileCopy(String input, String output)
    {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run()
    {
        try (FileInputStream fis = new FileInputStream(input); FileOutputStream fos = new FileOutputStream(output))
        {
            byte[] buffer = new byte[1024];
            int byteread = 0;
            for (; (byteread = fis.read(buffer)) > 0;)
            {
                fos.write(buffer,0, byteread);
            }
            System.out.println("File " + input + "\ncopied to " + output + "\n");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}