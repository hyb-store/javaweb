package com.hyb.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 3. cookie能不能存中文？
 * 		* 在tomcat 8 之前 cookie中不能直接存储中文数据。
 * 			* 需要将中文数据转码---一般采用URL编码(%E3)
 * 		* 在tomcat 8 之后，cookie支持中文数据。特殊字符还是不支持，建议使用URL编码存储，URL解码解析
 *
 * 	4. cookie共享问题？
 * 		1. 假设在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
 * 			* 默认情况下cookie不能共享
 *
 * 			* setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录
 * 				* 如果要共享，则可以将path设置为"/"
 * 		2. 不同的tomcat服务器间cookie共享问题？
 * 			* setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
 * 				* setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中cookie可以共享
 *
 * 	5. Cookie的特点和作用
 * 	1. cookie存储数据在客户端浏览器
 * 	2. 浏览器对于单个cookie 的大小有限制(4kb) 以及 对同一个域名下的总cookie数量也有限制(20个)
 *
 * 	* 作用：
 * 		1. cookie一般用于存出少量的不太敏感的数据
 * 		2. 在不登录的情况下，完成服务器对客户端的身份识别
 */

@WebServlet("/cookieDemo5")
public class CookieDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie c1 = new Cookie("msg","你好");
        //设置path，让当前服务器下部署的所有项目共享Cookie信息
        c1.setPath("/");

        //3.发送Cookie
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
