package Demo;


import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is Server Software
 * Created by Faron on 2017/1/3.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器，指定服务器的端口
        ServerSocket server = new ServerSocket(10010);
        //创建一个数据通道 socket 等待客户端接入   阻塞式接受，可设置多线程
        Socket socket =server.accept();
        //在浏览器中输入 http://localhost:10010/时 表示有用户连入 输出如下语句 浏览器是一个基于TCP传输协议/HTTP应用协议的客户端
        //也可以创建一个客户端
        System.out.println("一个客户端创建了连接");

        //创建数据
        String msg = "欢迎使用TCP！";
        //装饰 发送数据
//        BufferedWriter bfw = new BufferedWriter((new OutputStreamWriter(socket.getOutputStream())));    //在通道上OutputStream输出 所以获取 socket通道的输出流
//
//        bfw.write(msg);
//        bfw.newLine(); //因为使用BufferedWriter装饰 ，所以必须输出换行符号
//        bfw.flush();

/*
使用DataOutputStream 和DataInputStream来代替上面的数据接收方式和发送方式
 */

        DataOutputStream dps = new DataOutputStream(socket.getOutputStream());
        dps.writeUTF(msg);
        dps.flush();


    }
}
