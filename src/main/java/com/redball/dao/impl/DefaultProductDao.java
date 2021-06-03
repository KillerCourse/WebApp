package com.redball.dao.impl;

import com.redball.SqlConnector;
import com.redball.dao.ProductDao;
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

    @Override
    public List<ProductEntity> getAll() {
        try {
            Connection firstConnection = SqlConnector.getConnection();
            ResultSet productResultSet = getProductResultSet(firstConnection);
            return getProductsFromDB(productResultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private ResultSet getProductResultSet(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(GET_ALL_PRODUCTS);
        }
    }

    private ProductEntity getProductsEntity(ResultSet resultSet) throws SQLException {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(resultSet.getInt(ProductEntity.ID_COLUMN));
        productEntity.setDiameter(resultSet.getDouble(ProductEntity.DIAMETER_COLUMN));
        productEntity.setWeight(resultSet.getDouble(ProductEntity.WEIGHT_COLUMN));
        productEntity.setQuantity(resultSet.getInt(ProductEntity.QUANTITY_IN_STOCK_COLUMN));
        productEntity.setPricePerUnit(resultSet.getDouble(ProductEntity.PRICE_PER_UNIT_COLUMN));
        productEntity.setName(resultSet.getString(ProductEntity.NAME_COLUMN));
        productEntity.setDescription(resultSet.getString(ProductEntity.DESCRIPTION_COLUMN));

        return productEntity;
    }

    private List<ProductEntity> getProductsFromDB(ResultSet resultSet) throws SQLException {
        List<ProductEntity> products = new ArrayList<>();
        while (resultSet.next()) {
            ProductEntity productEntity = getProductsEntity(resultSet);
            products.add(productEntity);
        }
        return products;
    }
}
