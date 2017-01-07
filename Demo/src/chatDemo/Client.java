package chatDemo;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Faron on 2017/1/3.
 */
public class Client {
    public static void main (String[] args)throws IOException {
        //创建客户端，也就是创建数据通道
        Socket socket007 = new Socket("PC-20160927HYMN",10010);
        //接收数据
        //阻塞式接收
        DataInputStream dis = new DataInputStream(socket007.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);
    }
}
