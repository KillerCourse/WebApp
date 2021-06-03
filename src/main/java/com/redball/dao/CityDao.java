package com.redball.dao;

import com.redball.entity.CityEntity;

import java.util.List;

/**
 * provides methods to work with cities.
 */
public interface CityDao {
    /**
     * Gets cities from database.
     *
     * @return list of cities if found, otherwise returns null
     */

    List <CityEntity> getAll();
}
