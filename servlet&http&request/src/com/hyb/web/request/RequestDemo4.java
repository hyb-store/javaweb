package com.hyb.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头数据referer
        String referer = request.getHeader("referer");
        System.out.println(referer);//http://localhost:8080/request/login.html

        //防盗链
        if(referer != null) {
            if(referer.contains("request")) {
                //正常播放
               // System.out.println("播放电影");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影");
            }else {
                //倒链
               // System.out.println("无法播放");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("无法播放");
            }
        }

    }
}
