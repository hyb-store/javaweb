package com.hyb.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
1. request对象和response对象的原理
	1. request和response对象是由服务器创建的。我们来使用它们
	2. request对象是来获取请求消息，response对象是来设置响应消息

2. request对象继承体系结构：
	ServletRequest		--	接口
		|	继承
	HttpServletRequest	-- 接口
		|	实现
	org.apache.catalina.connector.RequestFacade 类(tomcat)

 */
@WebServlet("/ServletDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
        1. 获取请求方式 ：GET
					* String getMethod()
				2. (*)获取虚拟目录：/day14
					* String getContextPath()
				3. 获取Servlet路径: /demo1
					* String getServletPath()
				4. 获取get方式请求参数：name=zhangsan
					* String getQueryString()
				5. (*)获取请求URI：/day14/demo1
					* String getRequestURI():		/day14/demo1
					* StringBuffer getRequestURL()  :http://localhost/day14/demo1

					* URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
					* URI：统一资源标识符 : /day14/demo1					共和国

				6. 获取协议及版本：HTTP/1.1
					* String getProtocol()

				7. 获取客户机的IP地址：
					* String getRemoteAddr()
         */
        String method = request.getMethod();
        System.out.println(method);//GET

        String contextPath = request.getContextPath();
        System.out.println(contextPath);///request

        String servletPath = request.getServletPath();
        System.out.println(servletPath);///ServletDemo1

        String queryString = request.getQueryString();
        System.out.println(queryString);//name=zhangsan

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);//request//ServletDemo1

        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);//http://localhost:8080/request//ServletDemo1

        String protocol = request.getProtocol();
        System.out.println(protocol);//HTTP/1.1

        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);//0:0:0:0:0:0:0:1
    }
}
