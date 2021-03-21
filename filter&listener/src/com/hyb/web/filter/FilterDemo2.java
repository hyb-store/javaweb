package com.hyb.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request请求消息增强
        System.out.println("filterDemo2执行了...");

        //放行
        chain.doFilter(req, resp);

        //对response响应消息增强
        System.out.println("filterDemo2回来了...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }


}
