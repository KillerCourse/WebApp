package com.epam.redball.dao.impl;

import com.epam.redball.dao.OrderDao;
import com.epam.redball.entity.BaseEntity;
import com.epam.redball.entity.OrderEntity;
import com.epam.redball.dao.SqlConnectorDeleteLater;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private static final String GET_ALL_ORDERS = "SELECT * FROM order";
    @Override
    public List<OrderEntity> getAll() {
        try {
            Connection firstConnection = SqlConnectorDeleteLater.getConnection();
            ResultSet resultSet = getOrderResultSet(firstConnection);
            return getOrdersFromDB(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private ResultSet getOrderResultSet(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(GET_ALL_ORDERS);
        }
    }

    private OrderEntity getOrderEntity(ResultSet resultSet) throws SQLException{
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId(resultSet.getInt(BaseEntity.ID_COLUMN));
        orderEntity.setUserId(resultSet.getInt(OrderEntity.USER_ID_COLUMN));
        orderEntity.setCreationDate(resultSet.getDate(OrderEntity.CREATION_DATE_COLUMN));
        orderEntity.setOrderStatus(resultSet.getInt(OrderEntity.ORDER_STATUS_COLUMN));

        return orderEntity;
    }

    private List<OrderEntity> getOrdersFromDB(ResultSet resultSet) throws SQLException{
        List<OrderEntity> orders = new ArrayList<>();

        while (resultSet.next()){
            OrderEntity orderEntity = getOrderEntity(resultSet);
            orders.add(orderEntity);
        }
        return orders;
    }
}
