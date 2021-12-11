package com.epam.redball.action.impl;

import com.epam.redball.action.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (password.equals(confirmPassword)) {

        }

    }
}
