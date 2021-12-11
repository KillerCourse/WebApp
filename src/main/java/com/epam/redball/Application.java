package com.epam.redball;

import com.epam.redball.dao.impl.ProductDaoImpl;

import java.sql.SQLException;


public class Application {
    public static void main(String[] args) throws SQLException {
        com.epam.redball.dao.ProductDao productDao = new ProductDaoImpl();
        System.out.println(productDao.getAll());
    }
}
