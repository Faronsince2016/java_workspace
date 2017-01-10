package HttpServer02;

import java.io.IOException;
import java.net.Socket;


/**
 * Created by Faron on 2017/1/9.
 */
public class Dispatcher implements Runnable {
    private Socket socket;
    private Request req;
    private Response rep;
    private int code = 200;

    public Dispatcher(Socket socket) {
        try {
            this.socket = socket;
            req = new Request(socket.getInputStream());
            rep = new Response(socket.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            code = 500;
        }

    }


    @Override
    public void run() {
        Servlet servlet = new Servlet();
        servlet.service(rep, req);

        try {
            rep.PushToClient(code);
        } catch (IOException e) {

            try {
                rep.PushToClient(500);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        CloseUtil.CloseAll(socket);  //socket关闭   其他流也就关闭了
    }
}
