package com.hyb.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  	1. 响应行
 * 			1. 组成：协议/版本 响应状态码 状态码描述
 * 			2. 响应状态码：服务器告诉客户端浏览器本次请求和响应的一个状态。
 * 				1. 状态码都是3位数字
 * 				2. 分类：
 * 					1. 1xx：服务器就收客户端消息，但没有接受完成，等待一段时间后，发送1xx多状态码
 * 					2. 2xx：成功。代表：200
 * 					3. 3xx：重定向。代表：302(重定向)，304(访问缓存)
 * 					4. 4xx：客户端错误。
 * 						* 代表：
 * 							* 404（请求路径没有对应的资源）
 * 							* 405：请求方式没有对应的doXxx方法
 * 					5. 5xx：服务器端错误。代表：500(服务器内部出现异常)
 * 		2. 响应头：
 * 			1. 格式：头名称： 值
 * 			2. 常见的响应头：
 * 				1. Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式
 * 				2. Content-disposition：服务器告诉客户端以什么格式打开响应体数据
 * 					* 值：
 * 						* in-line:默认值,在当前页面内打开
 * 						* attachment;filename=xxx：以附件形式打开响应体。文件下载
 * 		3. 响应空行
 * 		4. 响应体:传输的数据
 */
@WebServlet("/servletDemo1")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i = 3/0;
        //类型 异常报告
        //
        //消息 / by zero
        //
        //描述 服务器遇到一个意外的情况，阻止它完成请求。
        //
        //例外情况
        //
        //java.lang.ArithmeticException: / by zero
        //	com.hyb.web.servlet.ServletDemo1.doGet(ServletDemo1.java:42)
        //	javax.servlet.http.HttpServlet.service(HttpServlet.java:626)
        //	javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
    }
}
