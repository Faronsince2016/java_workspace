package Demo;

import java.io.*;

/**
 * Created by Faron on 2017/1/1.
 */
public class IODemo4 {
    public static void main(String[] args)
    {
        try
        {
            FileReader fr=new FileReader("F://a.txt");
            BufferedReader br=new BufferedReader(fr);
            FileWriter fw=new FileWriter("F://33.txt");
            PrintWriter pw=new PrintWriter(fw);

            String s=br.readLine();
            while(null!=s)
            {
                //
                //PrintWriter的println方法 相当于
                //BufferedWriter 的write() + newLine()
                //
                pw.println(s); //将a.txt中的按行打印到33.txt中
                s=br.readLine();
            }

            br.close();
            pw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
