package com.hyb.web.servlet;

import com.hyb.domain.PageBean;
import com.hyb.domain.User;
import com.hyb.service.UserService;
import com.hyb.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.获取参数
        String currentPage = request.getParameter("currentPage"); //当前页码
        String rows = request.getParameter("rows"); //每页显示的条数

        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "10";
        }

        //2.调用service查询
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage,rows);
        //System.out.println(pb);

        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
