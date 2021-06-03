package com.redball.dao.impl;

import com.redball.SqlConnector;
import com.redball.dao.UserDao;
import com.redball.entity.UserEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultUserDao implements UserDao {
    private static final String GET_ALL_USERS = "SELECT * FROM user";

    @Override
    public List<UserEntity> getAll() {
        try {
            Connection firstConnection = SqlConnector.getConnection();
            ResultSet userResultSet = getUsersResultSet(firstConnection);
            return getUsersFromDB(userResultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private ResultSet getUsersResultSet(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(GET_ALL_USERS);
        }
    }

    private UserEntity getUsersEntity(ResultSet resultSet) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(resultSet.getInt(UserEntity.ID_COLUMN));
        userEntity.setLogin(resultSet.getString(UserEntity.LOGIN_COLUMN));
        userEntity.setPassword(resultSet.getString(UserEntity.PASSWORD_COLUMN));
        userEntity.setAddress(resultSet.getString(UserEntity.ADDRESS_COLUMN));
        userEntity.setName(resultSet.getString(UserEntity.NAME_COLUMN));
        userEntity.setSurname(resultSet.getString(UserEntity.SURNAME_COLUMN));
        userEntity.setEmail(resultSet.getString(UserEntity.EMAIL_COLUMN));
        userEntity.setDate(resultSet.getDate(UserEntity.DATE_OF_BIRTH_COLUMN));
        userEntity.setAdmin(resultSet.getBoolean(UserEntity.IS_ADMIN_COLUMN));
        userEntity.setLanguageId(resultSet.getInt(UserEntity.LANGUAGE_COLUMN));
        userEntity.setCityId(resultSet.getInt(UserEntity.CITY_ID_COLUMN));

        return userEntity;
    }

    private List<UserEntity> getUsersFromDB(ResultSet resultSet) throws SQLException {
        List<UserEntity> users = new ArrayList<>();
        while (resultSet.next()) {
            UserEntity userEntity = getUsersEntity(resultSet);
            users.add(userEntity);
        }
        return users;
    }
}



