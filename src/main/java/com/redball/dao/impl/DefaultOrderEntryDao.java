package com.redball.dao.impl;

import com.redball.dao.SqlConnectorDeleteLater;
import com.redball.dao.OrderEntryDao;
import com.redball.entity.Entity;
import com.redball.entity.OrderEntryEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultOrderEntryDao implements OrderEntryDao {
    private static final String GET_ALL_ORDER_ENTRY = "SELECT * FROM order_entry";

    @Override
    public List<OrderEntryEntity> getAll() {
        try {
            Connection connection = SqlConnectorDeleteLater.getConnection();
            ResultSet resultSet = getOrderEntryResultSet(connection);
            return getOrdersFromDB(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private ResultSet getOrderEntryResultSet(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(GET_ALL_ORDER_ENTRY);
        }
    }

    private OrderEntryEntity getOrderEntryEntity(ResultSet resultSet) throws SQLException {
        OrderEntryEntity orderEntryEntity = new OrderEntryEntity();

        orderEntryEntity.setId(resultSet.getInt(Entity.ID_COLUMN));
        orderEntryEntity.setOrderId(resultSet.getInt(OrderEntryEntity.ORDER_ID_COLUMN));
        orderEntryEntity.setProductId(resultSet.getInt(OrderEntryEntity.PRODUCT_ID_COLUMN));
        orderEntryEntity.setQuantity(resultSet.getInt(OrderEntryEntity.QUANTITY_COLUMN));
        orderEntryEntity.setPrice(resultSet.getDouble(OrderEntryEntity.PRICE_COLUMN));

        return orderEntryEntity;
    }

    private List<OrderEntryEntity> getOrdersFromDB(ResultSet resultSet) throws SQLException {
        List<OrderEntryEntity> orderEntry = new ArrayList<>();

        while (resultSet.next()) {
            OrderEntryEntity orderEntryEntity = getOrderEntryEntity(resultSet);
            orderEntry.add(orderEntryEntity);
        }
        return orderEntry;
    }
}
