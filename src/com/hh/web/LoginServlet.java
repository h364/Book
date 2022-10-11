package com.hh.web;

import com.hh.pojo.User;
import com.hh.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("login_name");
        String password = req.getParameter("login_password");
        String email = req.getParameter("login_email");

        User user = userService.login(username, password, email);
        if(user == null) {
            resp.sendRedirect("/book/pages/user/login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
