package com.hh.web;

import com.hh.dao.UserDao;
import com.hh.pojo.User;
import com.hh.services.impl.UserServiceImpl;
import com.hh.services.impl.UserdaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("regist_name");
        String password = req.getParameter("regist_password");
        String email = req.getParameter("regist_email");

        User user = new User(null, username, password, email);

        User userDb = userService.userExsistByName(username);
        System.out.println(user);
        if(userDb == null) {
            int affectedRow = userService.saveUserToDB(user);
        }else{
            resp.getWriter().append("false");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
