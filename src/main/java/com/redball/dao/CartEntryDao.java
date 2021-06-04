package com.redball.dao;

import com.redball.entity.CartEntryEntity;

import java.util.List;

/**
 * provides methods to work with carts.
 */
public interface CartEntryDao {
    /**
     * Gets CartEntry from database.
     *
     * @return list of CartEntry if found, otherwise returns null
     */

    List<CartEntryEntity> getAll();
}
