package com.hh.services.impl;

import com.hh.dao.UserDao;
import com.hh.dao.impl.BasicDAO;
import com.hh.pojo.User;

public class UserdaoImpl extends BasicDAO<User> implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from `user` where username = ?";
        return querySingle(sql, User.class, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from `user` where username = ? and password = ?";
        return querySingle(sql, User.class, "admin", "123456");
    }


    @Override
    public int saveUser(User user) {
        String sql = "insert into `user`(`username`, `password`, `email`) values(?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public User queryUserByEmail(String email) {
        String sql = "select * from `user` where email = ?";
        return querySingle(sql, User.class, email);
    }
}
