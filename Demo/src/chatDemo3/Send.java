package chatDemo3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Faron on 2017/1/3.
 */
public class Send implements Runnable {
    private String name;
    //控制台的输入流
    private BufferedReader console;
    //管道输出流
    private DataOutputStream dos;
    //控制线程的标识
    private boolean isRunning = true;
    //构造器 相关的初始化
    public  Send(){
        console = new BufferedReader(new InputStreamReader(System.in));
    }
    public Send(Socket socket,String name){
        this();
        try {
            dos= new DataOutputStream(socket.getOutputStream());
            this.name =name;
            send(this.name);
        } catch (IOException e) {
                isRunning =false;
                CloseUtil.CloseAll(dos, console);
        }
    }

    //从控制台获取数据
    private String getMsgFromConsole(){

        try {
            return console.readLine();
        } catch (IOException e) {
            return "";
        }


    }


    //发送信息
    public void send(String msg)  {
            try {
                if (msg!=null&&!msg.equals("")) {
                    dos.writeUTF(msg);
                    dos.flush();
                }
            } catch (IOException e) {
                System.out.println("send error！");
            }


    }
    //线程体
    @Override
    public void run() {
        while(isRunning) send(getMsgFromConsole());
    }

}
