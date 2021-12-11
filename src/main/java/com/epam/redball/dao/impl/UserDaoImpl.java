package com.epam.redball.dao.impl;

import com.epam.redball.dao.UserDao;
import com.epam.redball.database.connection.ConnectionPool;
import com.epam.redball.entity.UserEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class UserDaoImpl implements UserDao {
    private static final String GET_ALL_USERS = "SELECT  * FROM user";

    private static final String GET_USER_BY_LOGIN = "SELECT * FROM user WHERE login = ?";

    private static final String ADD_USER = "INSERT INTO user (NAME, SURNAME, LOGIN, PASSWORD, EMAIL, IS_ADMIN) " +
            "VALUES (?,?,?,?,?,?)";

    @Override
    public List<UserEntity> getAll() throws SQLException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();


        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return getUsersFromDB(resultSet);
        } catch (SQLException e) {

            return Collections.emptyList();
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }

    public UserEntity getUserByLogin(String login) throws SQLException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return getUserEntity(resultSet);
            }
            return null;
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public UserEntity create(UserEntity user) throws SQLException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setBoolean(6, user.isAdmin());
            preparedStatement.executeUpdate();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return null;
    }

    private ResultSet getUsersResultSet(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(GET_ALL_USERS);
        }
    }

    private UserEntity getUserEntity(ResultSet resultSet) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(resultSet.getInt(UserEntity.ID_COLUMN));
        userEntity.setLogin(resultSet.getString(UserEntity.LOGIN_COLUMN));
        userEntity.setPassword(resultSet.getString(UserEntity.PASSWORD_COLUMN));
        userEntity.setName(resultSet.getString(UserEntity.NAME_COLUMN));
        userEntity.setSurname(resultSet.getString(UserEntity.SURNAME_COLUMN));
        userEntity.setEmail(resultSet.getString(UserEntity.EMAIL_COLUMN));
        userEntity.setAdmin(resultSet.getBoolean(UserEntity.IS_ADMIN_COLUMN));
        userEntity.setLanguageId(resultSet.getInt(UserEntity.LANGUAGE_COLUMN));

        return userEntity;
    }

    private List<UserEntity> getUsersFromDB(ResultSet resultSet) throws SQLException {
        List<UserEntity> users = new ArrayList<>();
        while (resultSet.next()) {
            UserEntity userEntity = getUserEntity(resultSet);
            users.add(userEntity);
        }
        return users;
    }
}



