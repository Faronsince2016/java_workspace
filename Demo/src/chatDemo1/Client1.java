package chatDemo1;

import java.io.*;
import java.net.Socket;

/**
 * Created by Faron on 2017/1/3.
 */
public class Client1 {
    public static void main (String[] args)throws IOException {
        //创建客户端，也就是创建数据通道
        Socket socket007 = new Socket("PC-20160927HYMN",10010);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream dis = new DataInputStream(socket007.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket007.getOutputStream());
        //控制台输入流
        while (true) { //需要解决输入输出流在一个线程内的问题
            //通过管道输出
            dos.writeUTF(console.readLine());
            //通过管道输入
            //阻塞式接收
            String msg = dis.readUTF();
            System.out.println(msg);
        }
    }
}
