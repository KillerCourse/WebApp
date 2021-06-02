package com.redball.dao.impl;

import com.redball.SqlConnector;
import com.redball.dao.ProductDao;
import com.redball.entity.ProductsEntity;

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
    public List<ProductsEntity> getAllProducts() {
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

    private List<ProductsEntity> getProductsFromDB(ResultSet resultSet) throws SQLException {
        List<ProductsEntity> products = new ArrayList<>();
        while (resultSet.next()) {
            ProductsEntity productsEntity = getProductEntity(resultSet);
            products.add(productsEntity);
        }
        return products;
    }

    private ProductsEntity getProductEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ProductsEntity.ID_COLUMN);
        double diameter = resultSet.getDouble(ProductsEntity.DIAMETER_COLUMN);
        double weight = resultSet.getDouble(ProductsEntity.WEIGHT_COLUMN);
        int quantityInStock = resultSet.getInt(ProductsEntity.QUANTITY_IN_STOCK_COLUMN);
        double pricePerUnit = resultSet.getDouble(ProductsEntity.PRICE_PER_UNIT_COLUMN);
        String name = resultSet.getString(ProductsEntity.NAME_COLUMN);
        String description = resultSet.getString(ProductsEntity.DESCRIPTION_COLUMN);

        return new ProductsEntity(id, diameter, weight, quantityInStock, pricePerUnit, name, description);
    }
}
