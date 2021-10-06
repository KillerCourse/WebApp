package com.redball.action.impl;

import com.redball.action.Action;
import com.redball.dao.UserDao;
import com.redball.dao.impl.DefaultUserDao;
import com.redball.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (password.equals(confirmPassword)) {
            UserEntity user = createUser(request);
            UserDao userDao = new DefaultUserDao();
            try {
                userDao.create(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            response.sendRedirect("/userpage");
        } else {
            response.sendRedirect("/login");
        }
    }

    public UserEntity createUser(HttpServletRequest request) {
        UserEntity user = new UserEntity();
        user.setName(request.getParameter("firstName"));
        user.setSurname(request.getParameter("lastName"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setAdmin(false);
        return user;
    }

}
