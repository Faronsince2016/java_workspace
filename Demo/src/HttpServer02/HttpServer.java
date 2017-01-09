package HttpServer02;

import java.io.*;
import java.net.ServerSocket;


/**
 * Created by Faron on 2017/1/8.
 */
public class HttpServer {
    private ServerSocket server;
    private boolean isShutDown = false;
    public int len;
    public static void main(String[] args) {
        HttpServer svobj = new HttpServer();
        svobj.start(8888);
    }


    public void start(int port) {
        try {
            server = new ServerSocket(port);
            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receive() {
        while (!isShutDown) {
            try {
                new Thread(new Dispatcher(server.accept())).start();

            } catch (IOException e) {
                stop();
            }
        }
    }

    private void stop(){
        isShutDown = true;
        CloseUtil.CloseAll(server);
    }
}
