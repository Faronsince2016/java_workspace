package chatDemo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Faron on 2017/1/3.
 */
public class Server1 {
    public static void main(String[] args) throws IOException {
        //创建服务器，指定服务器的端口
        ServerSocket server = new ServerSocket(10010);
        //创建一个数据通道 socket 等待客户端接入   阻塞式接受，可设置多线程
        Socket socket = server.accept();  //这样的结构  导致关闭客户端的时候会出现NullPointException
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dps = new DataOutputStream(socket.getOutputStream());
        while (true) { //一个accept（）一个客户端
            //这时用浏览器就不行了，因为要符合格式
            System.out.println("一个客户端创建了连接");
            //通过管道接受数据
            String msg = dis.readUTF();
            //创建数据
            String msg1 = "欢迎使用TCP！服务器给你返回了：";
            //装饰 发送数据
            dps.writeUTF(msg1+msg);
            dps.flush();

        }
    }
}
