package com.epam.redball.dao.impl;

import com.epam.redball.dao.CartDao;
import com.epam.redball.database.connection.ConnectionPool;
import com.epam.redball.entity.BaseEntity;
import com.epam.redball.entity.CartEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private static final String GET_ALL_CARTS = "SELECT * FROM cart";
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final ConnectionPool connectionPool;

    public CartDaoImpl() {
        this.connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public List<CartEntity> getAll() {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CARTS)) {
            ResultSet cartResultSet = preparedStatement.executeQuery();

            return getCartsFromDB(cartResultSet);
        } catch (SQLException e) {
            LOGGER.warn(e);
            return Collections.emptyList();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    private CartEntity getCartsEntity(ResultSet resultSet) throws SQLException {
        CartEntity cartEntity = new CartEntity();

        cartEntity.setId(resultSet.getInt(BaseEntity.ID_COLUMN));
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
