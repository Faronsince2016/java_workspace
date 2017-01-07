package chatDemo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Faron on 2017/1/3
 */
public class Client2 {
    public static void main (String[] args)throws IOException {
        System.out.println("请输入昵称：");
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String name = bfr.readLine();
        //创建客户端，也就是创建数据通道
        Socket socket007 = new Socket("PC-20160927HYMN",10010);
        //启动线程
        new Thread(new Send(socket007,name)).start();
        new Thread(new Receive(socket007)).start();
    }
}
