package com.hh.dao;

import com.hh.pojo.User;

public interface UserDao {
    /**
     *
     * @param Username 用户名
     * @return null表示没有用户
     */
    public User queryUserByUsername(String Username);

    /**
     *
     * @param Username 用户名
     * @param password 密码
     * @return 返回null，说明没有用户或者密码错误
     */
    public User queryUserByUsernameAndPassword(String Username, String password);

    /**
     *
     * @param user 用户对象
     * @return 返回1表示成功
     */
    public int saveUser(User user);

    public User queryUserByEmail(String email);
}
