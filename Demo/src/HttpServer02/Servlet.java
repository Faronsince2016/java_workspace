package HttpServer02;

/**
 * Created by Faron on 2017/1/9.
 */
public class Servlet {
    public void service(Response rep, Request req) {
        if (null != req.getParameter("uname")) {
            rep.CreatContent("Hello !---").CreatContent(req.getParameter("uname")).CreatContent("欢迎你!!！");

        }
    }
}
