package chatDemo2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Faron on 2017/1/4.
 */
public class Receive implements Runnable {
    private DataInputStream dis;
    private boolean isRunning = true;

    //构造器初始化
    public Receive() {
    }

    public Receive(Socket socket) {
        this();
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.CloseAll(dis);
        }
    }

    //接收数据
    public String receive() {
        String msg = null;
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.CloseAll(dis);
        }
        return msg;

    }


    @Override
    public void run() {
        while (isRunning) {
            String str = receive();
            System.out.println(str);
        }
    }
}
