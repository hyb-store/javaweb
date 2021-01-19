package com.hyb.test;

import com.hyb.dao.UserDao;
import com.hyb.domain.User;
import org.junit.Test;

public class UserDaoTest {

    //测试类
    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("lisi");
        loginuser.setPassword("234");


        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
