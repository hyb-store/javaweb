package com.hyb.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * * 乱码问题：
 * 				1. PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1
 * 				2. 设置该流的默认编码
 * 				3. 告诉浏览器响应体使用的编码
 *
 * 				//简单的形式，设置编码，是在获取流之前设置
 *     			response.setContentType("text/html;charset=utf-8");
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流之前，设置流的默认编码
        //response.setCharacterEncoding("utf-8");
        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
        // Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式
        //response.setHeader("Content-Type","text/html;charset=utf-8");

        //简单的形式设置编码
        response.setContentType("text/html;charset=utf-8");


        //1.获取字符输出流
        PrintWriter pw = response.getWriter();//编码默认Iso-8859-1，解码默认gbk，所以乱码
        //2.输出数据
       // pw.write("hello response");
        //pw.write("<h1>hello response</h1>");
       // pw.write("你好 hello response");//乱码显示：?? hello response
        pw.write("你好啊啊啊 hello response");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
