package HttpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Faron on 2017/1/7.
 */
public class Server02 {
    private ServerSocket server;
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";

    public static void main(String[] args) {
        Server02 svobj = new Server02();
        svobj.start();
    }


    public void start() {
        try {
            server = new ServerSocket(9999);
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

        //响应的正文
        StringBuilder responseContext = new StringBuilder();
        responseContext.append("hello fengliwen!");
        //响应客户端的http请求
        StringBuilder response = new StringBuilder();
        //http协议版本、状态代码、对状态代码的描述
        response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
        //响应头Response Head
        response.append("Server:fengliwen-Server/0.0.1").append(CRLF);
        response.append("Content-Type:text/text/html;charset=GBK").append(CRLF);
        //正文长度、字节长度
        response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF); //一定是字节
        response.append("Date:").append(new Date()).append(CRLF);
        //正文之前的空行  必须有
        response.append(CRLF);
        //正文
        response.append(responseContext);
        System.out.println(response.toString());
        //输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(response.toString());
        bw.flush();
        bw.close();
    }
}
