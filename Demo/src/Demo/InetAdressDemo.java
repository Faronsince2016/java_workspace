package Demo;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;

/**
 * Created by Faron on 2017/1/1.
 */
public class InetAdressDemo {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostName());//获取本地主机名
        System.out.println(address.getHostAddress());//获取本地IP地址
        byte[] b = address.getAddress();
        System.out.println(b);

        URL url = new URL("http://www.baidu.com");



        System.out.println("主机名："+url.getHost());
        System.out.println("协议："+url.getProtocol());
        System.out.println("端口号："+url.getPort());   //返回-1时表示没有获取到端口号
        System.out.println("此 URL 的路径部分。："+url.getPath());
        System.out.println("此 URL 的查询部分："+url.getQuery());
        System.out.println("此 URL 的文件名："+url.getFile());
        System.out.println("锚点（也称为“引用”）："+url.getRef());



        /*InputStream is = url.openStream();

        这里牵扯到如何获取一个网页的编码方式：
        在网页的源代码中找到   <meta http-equiv="content-type" content="text/html;charset=gbk" />   gbk就为编码方式

        InputStreamReader isr = new InputStreamReader(is,"utf-8");
        BufferedReader bfr = new BufferedReader(isr);

        String data = bfr.readLine();
        while(data!=null){
            System.out.println(data);
            data = bfr.readLine();
        }

        is.close();
        isr.close();
        bfr.close();

        对这段代码进行重构
        */

        BufferedReader buf = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
        String data = null;
//        while((data=buf.readLine())!=null){
//            System.out.println(data);
//        }
//        buf.close();

        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("F://baidu.html"),"utf-8"));  //test pass
        while((data=buf.readLine())!=null){
            bfw.append(data);
            bfw.newLine();
        }
        bfw.flush();
        buf.close();
        bfw.close();

        InetAddress[] addr = InetAddress.getAllByName("www.163.com");
        //根据主机名解析IP地址的时候，返回的是一个InetAddress数组  每个element中存放了 www.163.com/122.70.134.19  这样的形态  可分别用getHostAddress()和getHostName()获取
        for (int i = 0; i < addr.length; i++) {
            System.out.println(addr[i]);
            System.out.println(addr[i].getHostAddress());//获取主机ＩＰ地址
            System.out.println(addr[i].getHostName());//获取主机名

        }
        InetAddress[] addr1 =InetAddress.getAllByName("122.70.134.19");
        for (int i = 0; i < addr1.length; i++) {
            System.out.println(addr1[i]);
            System.out.println(addr[i].getHostAddress());
            System.out.println(addr[i].getHostName());

        }

        // 也可以自己手动构造    InetSocketAddress isaddr = new InetSocketAddress(InetAddress.getByName("192.168.92.1"),9999);
        InetSocketAddress isaddr = new InetSocketAddress("192.168.92.1",9999); //对第一个参数，其实源码中也是调用了InetAddress.getByName()
        System.out.println(isaddr.getHostName());
        System.out.println(isaddr.getPort());

    }
}
