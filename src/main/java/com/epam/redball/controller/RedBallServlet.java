package com.epam.redball.controller;

import com.epam.redball.action.Action;
import com.epam.redball.action.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RedBallServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionFactory actionFactory = new ActionFactory();
        Action action = actionFactory.getAction(request);
        try {
            action.execute(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
