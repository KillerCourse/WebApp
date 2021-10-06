package com.redball.action.impl;

import com.redball.action.Action;
import com.redball.dao.impl.DefaultUserDao;
import com.redball.entity.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class SignInAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
       // RequestDispatcher dispatcher;

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DefaultUserDao userDao = new DefaultUserDao();
        UserEntity user = null;
        try {
            user = userDao.getUserByLogin(login);
            session.setAttribute("sessionUser", user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (user != null) {
            if (user.getPassword().equals(password)) {
                response.sendRedirect("/userpage");
            }
        } else {
            response.sendRedirect("/homepage");
        }
    }
}

