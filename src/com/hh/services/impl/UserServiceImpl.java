package com.hh.services.impl;

import com.hh.dao.UserDao;
import com.hh.pojo.User;

public class UserServiceImpl {
    public UserDao userdao = new UserdaoImpl();

    public User login(String username, String password, String email) {
        User user = userExsistByName(username);
        if(user == null) {
            return null;
        }else{
            return user;
        }
    }

    public User userExsistByName(String username) {
        User user = userdao.queryUserByUsername(username);
        return user;
    }

    public User userExsistByEmail(String email) {
        User user = userdao.queryUserByEmail(email);
        return user;
    }

    public int saveUserToDB(User user) {
        return userdao.saveUser(user);
    }
}
