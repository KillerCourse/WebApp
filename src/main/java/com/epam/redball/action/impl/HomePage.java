package com.epam.redball.action.impl;

import com.epam.redball.action.Action;
import com.epam.redball.dao.impl.ProductDaoImpl;
import com.epam.redball.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HomePage implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<ProductEntity> products = new ProductDaoImpl().getAll();
        request.setAttribute("products", products);

        request.getRequestDispatcher("/WEB-INF/jsp/homepage.jsp").forward(request, response);


    }
}
