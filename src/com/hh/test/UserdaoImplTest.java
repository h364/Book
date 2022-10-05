package com.hh.test;

import com.hh.dao.UserDao;
import com.hh.pojo.User;
import com.hh.services.impl.UserdaoImpl;

import static org.junit.Assert.*;

public class UserdaoImplTest {

    @org.junit.Test
    public void queryUserByUsername() {
        UserDao userDao = new UserdaoImpl();
        User user = userDao.queryUserByUsername("hh");
        System.out.println(user);
        System.out.println(user == null? "此用户不存在":"此用户已存在");
    }

    @org.junit.Test
    public void queryUserByUsernameAndPassword() {
    }

    @org.junit.Test
    public void saveUser() {
    }
}