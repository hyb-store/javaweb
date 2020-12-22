package com.hyb.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/ServletDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
        获取请求头数据
			* 方法：
				* (*)String getHeader(String name):通过请求头的名称获取请求头的值
				* Enumeration<String> getHeaderNames():获取所有的请求头名称
         */
        Enumeration<String> headerNames = request.getHeaderNames();
        //遍历
        while(headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String header = request.getHeader(name);
            System.out.println(name+"---"+header);
        }
//        host---localhost:8080
//        connection---keep-alive
//        upgrade-insecure-requests---1
//        user-agent---Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36
//        accept---text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//        sec-fetch-site---none
//        sec-fetch-mode---navigate
//        sec-fetch-dest---document
//        accept-encoding---gzip, deflate, br
//        accept-language---zh-CN,zh;q=0.9
//        cookie---JSESSIONID=7DF8DB2B9D37FA9D44B683BE066AD08E; Idea-5e3275da=df82ac2d-2878-42a0-8933-b1de86465655; Hm_lvt_55b574651fcae74b0a9f1cf9c8d7c93a=1608288551; BK_SEARCHLOG=%7B%22key%22%3A%5B%22jsoup%22%5D%7D; JSESSIONID=8D65969A3A3CCE0EB2D31E53830A307C

    }
}
