package com.redball.controller;

import com.redball.dao.impl.DefaultProductDao;
import com.redball.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/*@WebServlet("/hello")*/
public class MainServlet extends HttpServlet {
    private boolean executed = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DefaultProductDao defaultProductDao = null;
        try {
            defaultProductDao = new DefaultProductDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ProductEntity productById = defaultProductDao.getProductById(1);
        request.setAttribute("product", productById);
        request.setAttribute("asd", 2);
        if (!executed) {
            request.getSession().setAttribute("dsd", 1);
            executed = true;
        } else {
            Object dsd = request.getSession().getAttribute("dsd");
            System.out.println(dsd);
        }
        System.out.println(productById);
        request.getRequestDispatcher("/hello.jsp").forward(request, response);
    }
}
