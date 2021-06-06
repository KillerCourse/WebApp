package com.redball.dao.impl;

import com.redball.dao.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultConnectionPool implements ConnectionPool {
    private static DefaultConnectionPool instance;

    private static final String DATABASE_URL = "jdbc:mysql://localhost/firstschema";
    private static final String USER = "root";
    private static final String PASSWORD = "kik14051990";
    private static final int INITIAL_POOL_SIZE = 10;

    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    public static DefaultConnectionPool getInstance() throws SQLException {
        if (instance == null) {
            instance = new DefaultConnectionPool();
        }
        return instance;
    }

    private DefaultConnectionPool() throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection());
        }
        connectionPool = pool;
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }


}
