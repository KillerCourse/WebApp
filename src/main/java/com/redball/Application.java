package com.redball;

import com.redball.dao.ProductDao;
import com.redball.dao.impl.DefaultProductDao;

import java.sql.SQLException;


public class Application {
    public static void main(String[] args) throws SQLException {
        ProductDao productDao = new DefaultProductDao();
        System.out.println(productDao.getAll());
    }
}
