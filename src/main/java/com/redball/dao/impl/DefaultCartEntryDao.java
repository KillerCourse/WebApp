package com.redball.dao.impl;

import com.redball.SqlConnector;
import com.redball.dao.CartEntryDao;

import com.redball.entity.CartEntryEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultCartEntryDao implements CartEntryDao {

    private static final String GET_ALL_CART_ENTRY = "SELECT * FROM cart_entry";

    @Override
    public List<CartEntryEntity> getAll() {
        try {
            Connection firstConnection = SqlConnector.getConnection();
            ResultSet cartEntryResultSet = getCartEntryResultSet(firstConnection);
            return getCartsEntityFromDB(cartEntryResultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private ResultSet getCartEntryResultSet(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(GET_ALL_CART_ENTRY);
        }
    }

    private CartEntryEntity getCartEntryEntity(ResultSet resultSet) throws SQLException {
        CartEntryEntity cartEntryEntity = new CartEntryEntity();

        cartEntryEntity.setId(resultSet.getInt(CartEntryEntity.ID_COLUMN));
        cartEntryEntity.setCartId(resultSet.getInt(CartEntryEntity.CART_ID_COLUMN));
        cartEntryEntity.setProductId(resultSet.getInt(CartEntryEntity.PRODUCT_ID_COLUMN));
        cartEntryEntity.setOrderedQuantity(resultSet.getInt(CartEntryEntity.ORDERED_QUANTITY));

        return cartEntryEntity;
    }

    private List<CartEntryEntity> getCartsEntityFromDB(ResultSet resultSet) throws SQLException {
        List<CartEntryEntity> entryEntities = new ArrayList<>();
        while (resultSet.next()) {
            CartEntryEntity cartEntryEntity = getCartEntryEntity(resultSet);
            entryEntities.add(cartEntryEntity);
        }
        return entryEntities;
    }
}
