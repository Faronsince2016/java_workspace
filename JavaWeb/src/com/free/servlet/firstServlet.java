/**
 * Created by Faron on 2017/3/12.
 */
package com.free.servlet;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class firstServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("my first servlet! ");
        System.out.println(req.getHeader("User-Agent"));  //获取http头信息 打印在控制台~！

        resp.getWriter().println("<h1>hello servlet! </h1>");  //向浏览器传写字符
        resp.getWriter().print("<hr color ='red' / >");

    }
}
