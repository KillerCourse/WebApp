package com.epam.redball.dao;

import com.epam.redball.entity.OrderEntryEntity;

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
