package HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Faron on 2017/1/7.
 */
public class Server {
    private ServerSocket server;

    public static void main(String[] args) {
        Server svobj = new Server();
        svobj.start();
    }


    public void start() {
        try {
            server = new ServerSocket(8888);
            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receive() throws IOException {
        Socket socket = server.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = null;//用来接收字符串
        StringBuilder sb = new StringBuilder();//用来装msg
        while ((msg = br.readLine()).length() > 0) {
            sb.append(msg + "\n");
        }

        String RequestInfo = sb.toString().trim();
        System.out.println(RequestInfo);
    }
}
