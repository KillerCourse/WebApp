package com.redball.dao;

import com.redball.entity.CartEntryEntity;

import java.util.List;

/**
 * provides methods to work with carts.
 */
public interface CartEntryDao {
    /**
     * Gets carts from database.
     *
     * @return list of carts if found, otherwise returns null
     */

    List<CartEntryEntity> getAll();
}
