package com.redball.action.impl;

import com.redball.action.Action;
import com.redball.dao.ProductDao;
import com.redball.dao.impl.DefaultProductDao;
import com.redball.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HomePage implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<ProductEntity> products = new DefaultProductDao().getAll();
        request.setAttribute("products", products);

        request.getRequestDispatcher("/WEB-INF/jsp/homepage.jsp").forward(request, response);


    }
}
