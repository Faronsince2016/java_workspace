package Demo;


import java.io.*;

/**
 * Created by Administrator on 2017/1/1.
 */
public class IODemo1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一行文字");
        String str = bufr.readLine();
        while(str!=null) {
            System.out.println(str);
            str = bufr.readLine();
        }

    }


}
