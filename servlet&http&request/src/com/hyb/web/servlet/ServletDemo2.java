package com.hyb.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 *
 * 6. Servlet的体系结构
 * 	Servlet -- 接口
 * 		|
 * 	GenericServlet -- 抽象类
 * 		|
 * 	HttpServlet  -- 抽象类
 *
 * 	* GenericServlet：将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象
 * 		* 将来定义Servlet类时，可以继承GenericServlet，实现service()方法即可
 *
 * 	* HttpServlet：对http协议的一种封装，简化操作
 * 		1. 定义类继承HttpServlet
 * 		2. 复写doGet/doPost方法
 *
 * 7. Servlet相关配置
 * 	1. urlpartten:Servlet访问路径
 * 		1. 一个Servlet可以定义多个访问路径 ： @WebServlet({"/d4","/dd4","/ddd4"})
 * 		2. 路径定义规则：
 * 			1. /xxx：路径匹配
 * 			2. /xxx/xxx:多层路径，目录结构
 * 			3. *.do：扩展名匹配
 */
@WebServlet("/demo2")
public class ServletDemo2 extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo2...");
    }
}
