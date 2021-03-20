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

    /**
     * 查询总记录数
     * @return
     */
    public abstract int findTotalCount();

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @return
     */
    List<User> findByPage(int start, int rows);
}
