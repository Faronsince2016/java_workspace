package Demo;

import java.io.IOException;
import java.net.*;

/**
 * Created by Faron on 2017/1/3.
 */
public class MyClient {
    public  static  void  main(String[] args) throws IOException {
        //创建DatagramSocket  的client客户端 并且指定客户端的端口号
        DatagramSocket client = new DatagramSocket(10086);
        //准备数据 e.g. 字节数组
        String s = "你好，我是客户端！";
        byte[] container = s.getBytes();
        //获取本地计算机名
        //InetAddress address =InetAddress.getLocalHost();
        //System.out.println(address);
        //打包
        DatagramPacket packet = new DatagramPacket(container,container.length,new InetSocketAddress("PC-20160927HYMN",10010));
        //发送
        client.send(packet);

        //接受服务器的响应
        byte[] recFromServer = new byte[1024];
        DatagramPacket packet1 =new DatagramPacket(recFromServer,recFromServer.length);
        client.receive(packet1);
        byte[] data1 = packet1.getData();
        System.out.println(new String(data1,0,data1.length));
        //释放
        client.close();

//        //客户端
////1、定义服务器的地址、端口号、数据
//        InetAddress address =InetAddress.getByName("PC-20160927HYMN");
//        int port =10010;
//        byte[] data ="用户名：admin;密码：123".getBytes();
////2、创建数据报，包含发送的数据信息
//        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
////3、创建DatagramSocket对象
//        DatagramSocket socket =new DatagramSocket();
////4、向服务器发送数据
//        socket.send(packet);
//
//
////接受服务器端响应数据
////======================================
////1、创建数据报，用于接受服务器端响应数据
//        byte[] data2 = new byte[1024];
//        DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
////2、接受服务器响应的数据
//        socket.receive(packet2);
//        String reply = new String(data2,0,packet2.getLength());
//        System.out.println("我是客户端，服务器说："+reply);
////4、关闭资源
//        socket.close();
    }
}
