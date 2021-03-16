package com.hyb.service;

import com.hyb.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public abstract List<User> findAll();

    /**
     * 登录方法
     * @param user
     * @return
     */
    public abstract User login(User user);

    /**
     * 保存user对象
     * @param user
     */
    public abstract void addUser(User user);

    /**
     * 根据id删除User
     * @param id
     */
    public abstract void deleteUser(String id);
}
