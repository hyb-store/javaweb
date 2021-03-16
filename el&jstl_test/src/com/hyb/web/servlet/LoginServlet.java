package com.hyb.web.servlet;

import com.hyb.domain.User;
import com.hyb.service.UserService;
import com.hyb.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        //2.1获取用户填写的验证码
        String verifycode = request.getParameter("verifycode");

        //3.验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性

        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码正确
            //提示信息
            request.setAttribute("login_msg","验证码错误！");
            //跳转登录界面
            request.getRequestDispatcher("/login.jsp").forward(request,response);

            return;
        }

        Map<String, String[]> map = request.getParameterMap();
       /* 遍历map
        Set<Map.Entry<String, String[]>> entries = map.entrySet();
        for(Map.Entry<String,String[]> entry: entries){
            System.out.println(entry.getKey()+"="+ Arrays.toString(entry.getValue()));
        }*/
        //4.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);//map中的数据映射到JavaBean中的get和set方法中（封装数据到JavaBean中）
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //5.调用service查询
        UserService service = new UserServiceImpl();
        User loginuser = service.login(user);
        //6.判断是否判断成功
        //System.out.println("login:"+loginuser);

        if(loginuser != null){
            //登录成功
            //将用户存入session
            session.setAttribute("user",loginuser);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            //登陆失败
            //提示信息
            request.setAttribute("login_msg","用户名或密码错误！");
            //跳转登录界面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
