package com.redball.dao;

import com.redball.entity.CartsEntity;

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
    List<CartsEntity> getAllCarts();
}
