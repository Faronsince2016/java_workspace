package Demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * Created by Faron on 2017/1/3.
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        //创建服务端+指定端口
        DatagramSocket server = new DatagramSocket(10010);
        //创建接受容器
        byte[] container = new byte[1024];
        //用容器来创建DatagramPacket 的实例
        DatagramPacket packet = new DatagramPacket(container,container.length);
        //准备接受数据
        server.receive(packet);
        //从packet中获取数据 分析数据
        byte[] data = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(data,0,len));

        //向客户端发送数据
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "hello，i am server！".getBytes();
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
        server.send(packet2);
        //释放资源
        server.close();

//        //服务器端，实现基于UDP的用户登录
////1、创建服务器端DatagramSocket，指定端口
//        DatagramSocket socket =new DatagramSocket(10010);
////2、创建数据报，用于接受客户端发送的数据
//        byte[] data =new byte[1024];//
//        DatagramPacket packet =new DatagramPacket(data,data.length);
////3、接受客户端发送的数据
//        socket.receive(packet);//此方法在接受数据报之前会一致阻塞
////4、读取数据
//        String info =new String(data,0,data.length);
//        System.out.println("我是服务器，客户端告诉我"+info);
//
//
////=========================================================
////向客户端响应数据
////1、定义客户端的地址、端口号、数据
//        InetAddress address = packet.getAddress();
//        int port = packet.getPort();
//        byte[] data2 = "欢迎您！".getBytes();
////2、创建数据报，包含响应的数据信息
//        DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
////3、响应客户端
//        socket.send(packet2);
////4、关闭资源
//        socket.close();
    }
}
