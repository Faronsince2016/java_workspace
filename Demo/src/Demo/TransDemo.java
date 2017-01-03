package Demo;


import sun.nio.cs.ext.GBK;

import java.io.*;


/**
 * Created by Faron on 2017/1/1.
 */
public class TransDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader fr = new InputStreamReader(new FileInputStream("F://a.txt"),"utf-8");
        char[] b = new char[128];
        int HasRead = fr.read(b);
        while (HasRead!=-1) {
            System.out.print(b);
            HasRead = fr.read(b);
        }

        fr.close();

    }
}
