package com.epam.redball.dao;

import com.epam.redball.entity.CartEntity;

import java.util.List;

/**
 * provides methods to work with cart.
 */
public interface CartDao {
    /**
     * Gets carts from database.
     *
     * @return list of carts if found, otherwise returns null
     */
    List<CartEntity> getAll();
}
