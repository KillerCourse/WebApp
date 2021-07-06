package com.redball.controller;

import com.redball.dao.impl.DefaultProductDao;
import com.redball.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/*@WebServlet("/hello")*/
public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DefaultProductDao defaultProductDao = null;
        try {
            defaultProductDao = new DefaultProductDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // List<ProductEntity> products = defaultProductDao.getAll();
        request.setAttribute("products", Collections.emptyList()); // не забыть вернуть products
        request.getRequestDispatcher("/homepage.jsp").forward(request, response);
    }
}
