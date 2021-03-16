package com.hyb.dao;

import com.hyb.domain.User;

import java.util.List;

/**
 * 用户操作的Dao
 */
public interface UserDao {

    public abstract List<User> findAll();
    public abstract User findUserByUsernameAndPassword(String username, String password);


    public abstract void add(User user);

    public abstract void delete(int id);

    public abstract User findById(int id);

    public abstract void update(User user);
}
