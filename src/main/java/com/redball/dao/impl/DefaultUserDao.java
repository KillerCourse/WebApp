package com.redball.dao.impl;

import com.redball.SqlConnector;
import com.redball.dao.UserDao;
import com.redball.entity.UsersEntity;

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
    public List<UsersEntity> getAllUsers() {
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

    private List<UsersEntity> getUsersFromDB(ResultSet resultSet) throws SQLException {
        List<UsersEntity> users = new ArrayList<>();
        while (resultSet.next()) {
            UsersEntity userEntity = getUserEntity(resultSet);
            users.add(userEntity);
        }
        return users;
    }

    private UsersEntity getUserEntity(ResultSet resultSet) throws SQLException {
        UsersEntity userEntity = new UsersEntity();
        userEntity.setId(resultSet.getInt(UsersEntity.ID_COLUMN));
        userEntity.setLogin(resultSet.getString(UsersEntity.LOGIN_COLUMN));
        userEntity.setPassword(resultSet.getString(UsersEntity.PASSWORD_COLUMN));
        userEntity.setAddress(resultSet.getString(UsersEntity.ADDRESS_COLUMN));
        userEntity.setName(resultSet.getString(UsersEntity.NAME_COLUMN));
        userEntity.setSurname(resultSet.getString(UsersEntity.SURNAME_COLUMN));
        userEntity.setEmail(resultSet.getString(UsersEntity.EMAIL_COLUMN));
        userEntity.setDate(resultSet.getDate(UsersEntity.DATE_OF_BIRTH_COLUMN));
        userEntity.setAdmin(resultSet.getBoolean(UsersEntity.IS_ADMIN_COLUMN));
        userEntity.setLanguageId(resultSet.getInt(UsersEntity.LANGUAGE_COLUMN));
        userEntity.setCityId(resultSet.getInt(UsersEntity.CITY_ID_COLUMN));

        return userEntity;
    }
}



