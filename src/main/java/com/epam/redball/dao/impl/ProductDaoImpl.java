package com.epam.redball.dao.impl;

import com.epam.redball.dao.ProductDao;
import com.epam.redball.database.connection.ConnectionPool;
import com.epam.redball.entity.BaseEntity;
import com.epam.redball.entity.ProductEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    private static final String GET_ALL_PRODUCTS = "SELECT * FROM product";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ?";

    private final ConnectionPool connectionPool;

    public ProductDaoImpl() {
        this.connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public List<ProductEntity> getAll() {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            return getAllProductsEntity(connection);
        } catch (SQLException e) {
            LOGGER.warn(e);
            return Collections.emptyList();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public ProductEntity getProductById(long id) {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            return getProductEntity(connection, id);
        } catch (SQLException e) {
            LOGGER.warn(e);
            return null;
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    private ProductEntity getProductEntity(Connection connection, long id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet getResultSet = preparedStatement.executeQuery();
            if (getResultSet.next()) {
                return getProductFromResultSet(getResultSet);
            }
            return null;
        }
    }

    private List<ProductEntity> getAllProductsEntity(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS)) {
            ResultSet getResultSet = preparedStatement.executeQuery();
            return getListOfProductsFromDB(getResultSet);
        }
    }

    private ProductEntity getProductFromResultSet(ResultSet resultSet) throws SQLException {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(resultSet.getInt(BaseEntity.ID_COLUMN));
        productEntity.setDiameter(resultSet.getDouble(ProductEntity.DIAMETER_COLUMN));
        productEntity.setWeight(resultSet.getDouble(ProductEntity.WEIGHT_COLUMN));
        productEntity.setQuantity(resultSet.getInt(ProductEntity.QUANTITY_IN_STOCK_COLUMN));
        productEntity.setPricePerUnit(resultSet.getDouble(ProductEntity.PRICE_PER_UNIT_COLUMN));
        productEntity.setName(resultSet.getString(ProductEntity.NAME_COLUMN));
        productEntity.setDescription(resultSet.getString(ProductEntity.DESCRIPTION_COLUMN));

        return productEntity;
    }

    private List<ProductEntity> getListOfProductsFromDB(ResultSet resultSet) throws SQLException {
        List<ProductEntity> products = new ArrayList<>();
        while (resultSet.next()) {
            ProductEntity productEntity = getProductFromResultSet(resultSet);
            products.add(productEntity);
        }
        return products;
    }
}
