package com.hyb.servlet;

import com.hyb.dao.UserDao;
import com.hyb.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.封装User对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        //4.调用UserDao的Login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        //5.判断user
        if (user == null) {
            //登陆失败
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else {
            //登录成功，存储数据
            request.setAttribute("user",user);
            //转发
            //1. 通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
            //2. 使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response)
            request.getRequestDispatcher("/successServlet").forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
