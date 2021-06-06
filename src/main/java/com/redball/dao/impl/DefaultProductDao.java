package com.redball.dao.impl;

import com.redball.dao.ConnectionPool;
import com.redball.dao.ProductDao;
import com.redball.entity.Entity;
import com.redball.entity.ProductEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultProductDao implements ProductDao {
    private static final String GET_ALL_PRODUCTS = "SELECT * FROM product";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ";

    private final ConnectionPool connectionPool;

    public DefaultProductDao() throws SQLException {
        this.connectionPool = DefaultConnectionPool.getInstance();
    }

    @Override
    public List<ProductEntity> getAll() {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            return getListOfProductEntity(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public ProductEntity getProductById(long id) {
        String getProductById = GET_PRODUCT_BY_ID + id;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            return getProductEntity(connection, getProductById);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    private ProductEntity getProductEntity(Connection connection, String id) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet getResultSet = statement.executeQuery(id);
            getResultSet.next();
            return getProductFromResultSet(getResultSet);
        }
    }

    private List<ProductEntity> getListOfProductEntity(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet getResultSet = statement.executeQuery(GET_ALL_PRODUCTS);
            return getListOfProductsFromDB(getResultSet);
        }
    }

    private ProductEntity getProductFromResultSet(ResultSet resultSet) throws SQLException {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(resultSet.getInt(Entity.ID_COLUMN));
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
