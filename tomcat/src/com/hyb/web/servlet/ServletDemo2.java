package com.hyb.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * servlet的方法
 */
public class ServletDemo2 implements Servlet {
    /**
     * 初始化方法
     * 在servlet创建时执行只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("inti.....");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每一次servlet被访问，执行。会执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet...");
    }

    /**
     * 获取Servlet的一些信息，版本，作者等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器被正常关闭时执行，执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
