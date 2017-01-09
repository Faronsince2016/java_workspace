package HttpServer02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 封装Response
 * Created by Faron on 2017/1/8.
 */
public class Response {
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";
    //构造响应头
    private StringBuilder HeadInfo;
    private StringBuilder con;
    private BufferedWriter bw;
    public int len;
    //构造器
    public Response(){
        HeadInfo = new StringBuilder();
        con = new StringBuilder();
        len = 0;
    }
    public Response(OutputStream os){
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }
    public Response(Socket socket) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            HeadInfo = null;
        }
    }

    //构建正文
    public Response CreatContent(String info){
        con.append(info);
        len += info.getBytes().length;
        return this;
    }
    //正文+回车
    public Response CreatContentln(String info){
        con.append(info).append(CRLF);
        len += (info+CRLF).getBytes().length;
        return this;
    }

    //根据不同的应答码 构造不同的头信息
    public void CreatHeadInfo(int code, String charset){
        //http协议版本、状态代码、对状态代码的描述
        HeadInfo.append("HTTP /1.1").append(BLANK).append(code).append(BLANK);
        switch (code){
            case 200:
                HeadInfo.append("OK");
                break;
            case 404:
                HeadInfo.append("Not Found!");
                break;
            case 505:
                HeadInfo.append("Server Error!");
                break;
        }
        HeadInfo.append(CRLF);
        //响应头Response Head
        HeadInfo.append("Server:fengliwen-Server/0.0.1").append(CRLF);
        HeadInfo.append("Content-Type:text/text/html;charset="+charset).append(CRLF);
        //正文长度、字节长度
        HeadInfo.append("Content-Length:").append(len).append(CRLF); //一定是字节
        HeadInfo.append("Date:").append(new Date()).append(CRLF);
        //正文之前的空行  必须有
        HeadInfo.append(CRLF);
    }

    public void PushToClient(int code) throws IOException {
        if (null == HeadInfo){code = 500;}
        CreatHeadInfo(code,"gbk");
        bw.append(HeadInfo.toString());
        bw.append(con.toString());
        bw.flush();
        bw.close();
    }



}
