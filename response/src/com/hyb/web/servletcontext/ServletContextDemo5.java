package com.hyb.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*ServletContext功能：
               1. 获取MIME类型：
               2. 域对象：共享数据
               3. 获取文件的真实(服务器)路径   */

        //2. 通过HttpServlet获取
        ServletContext context = this.getServletContext();

        // 获取文件的服务器路径    classLoader只能获得src下文件路径，无法获得web下文件路径
        String b = context.getRealPath("/b.txt");//web目录下资源访问
        System.out.println(b);//E:\IdeaProjects\javaweb\out\artifacts\response_war_exploded\b.txt
        // File file = new File(realPath);

        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(c);//E:\IdeaProjects\javaweb\out\artifacts\response_war_exploded\WEB-INF\c.txt

        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(a);//E:\IdeaProjects\javaweb\out\artifacts\response_war_exploded\WEB-INF\classes\a.txt
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
