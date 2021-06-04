package com.redball.dao;

import com.redball.entity.OrderEntryEntity;

import java.util.List;

/**
 * Provides methods to work with OrderEntry
 */
public interface OrderEntryDao {
    /**
     * Gets OrderEntry from database
     *
     * @return list of OrderEntry if found, otherwise return null
     */

    List<OrderEntryEntity> getAll();
}
