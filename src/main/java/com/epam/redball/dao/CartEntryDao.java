package com.epam.redball.dao;

import com.epam.redball.entity.CartEntryEntity;

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
