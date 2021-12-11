package com.epam.redball.dao;

import com.epam.redball.entity.UserEntity;

import java.sql.SQLException;
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
    List<UserEntity> getAll() throws SQLException;

    UserEntity create(UserEntity user) throws SQLException;
}
