package com.redball.dao;

import com.redball.entity.ProductsEntity;

import java.util.List;

/**
 * Provides methods to work with products.
 */
public interface ProductDao {

    /**
     * Gets products from database.
     *
     * @return list of products if found, otherwise returns null
     */
    List<ProductsEntity> getAllProducts();
}
