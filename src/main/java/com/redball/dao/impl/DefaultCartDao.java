package com.redball.dao.impl;

import com.redball.dao.CartDao;
import com.redball.entity.CartsEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DefaultCartDao implements CartDao {
    public static final String GET_ALL_CARTS = "SELECT * FROM cart";

    @Override
    public List<CartsEntity> getAllCarts() {
        return null;
    }

    private ResultSet getCartResultSet(Connection connection) throws SQLException{
        try(Statement statement = connection.createStatement()) {
            return statement.executeQuery(GET_ALL_CARTS);
        }
    }
}
