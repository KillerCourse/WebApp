package com.redball.dao;

import com.redball.entity.UserEntity;

import java.util.List;

/**
 * Provides methods to work with users.
 */
public interface UserDao {
    /**
     * Gets users from database.
     *
     * @return list of users if found, otherwise returns null
     */

    List<UserEntity> getAll();
}
