package com.epam.redball.action.impl;

import com.epam.redball.action.Action;
import com.epam.redball.dao.impl.UserDaoImpl;
import com.epam.redball.entity.UserEntity;

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
        UserDaoImpl userDao = new UserDaoImpl();
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

