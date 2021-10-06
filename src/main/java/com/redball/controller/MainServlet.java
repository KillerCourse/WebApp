package com.redball.controller;

import com.redball.action.Action;
import com.redball.action.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MainServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionFactory actionFactory = new ActionFactory();//создали фабрику экшонов
        Action action = actionFactory.getAction(request);//создали экшон из фабрики
        try {
            action.execute(request, response);//выполнили экшон
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
//имплементировать нормально метод гетэкшон, ща всегда хоум пейдж вызывается. сделать еще один экшон