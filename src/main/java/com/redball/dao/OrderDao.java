package com.redball.dao;

import com.redball.entity.OrderEntity;

import java.util.List;

/**
 * provides methods to work with orders
 */
public interface OrderDao {
    /**
     * Gets orders from database.
     *
     * @return list of orders if found, otherwise returns null
     */
    List<OrderEntity> getAll();
}
