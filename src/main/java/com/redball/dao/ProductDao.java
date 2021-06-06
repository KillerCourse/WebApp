package com.redball.dao;

import com.redball.entity.ProductEntity;

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
    List<ProductEntity> getAll();

    /**
     * Gets product by id.
     *
     * @param id unique product identifier.
     * @return product for provided id.
     * if product not found returns null
     */
    ProductEntity getProductById(long id);
}
