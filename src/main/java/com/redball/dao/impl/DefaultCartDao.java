package com.redball.dao.impl;

import com.redball.SqlConnector;
import com.redball.dao.CartDao;
import com.redball.entity.CartEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultCartDao implements CartDao {
    private static final String GET_ALL_CARTS = "SELECT * FROM cart";

    @Override
    public List<CartEntity> getAll() {
        try {
            Connection firstConnection = SqlConnector.getConnection();
            ResultSet cartResultSet = getCartResultSet(firstConnection);
            return getCartsFromDB(cartResultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private ResultSet getCartResultSet(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(GET_ALL_CARTS);
        }
    }

    private CartEntity getCartsEntity(ResultSet resultSet) throws SQLException {
        CartEntity cartEntity = new CartEntity();

        cartEntity.setId(resultSet.getInt(CartEntity.ID_COLUMN));
        cartEntity.setUserId(resultSet.getInt(CartEntity.USER_ID_COLUMN));

        return cartEntity;
    }

    private List<CartEntity> getCartsFromDB(ResultSet resultSet) throws SQLException {
        List<CartEntity> carts = new ArrayList<>();
        while (resultSet.next()) {
            CartEntity cartEntity = getCartsEntity(resultSet);
            carts.add(cartEntity);
        }
        return carts;
    }
}
