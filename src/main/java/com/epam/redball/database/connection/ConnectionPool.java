package com.epam.redball.database.connection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Integer.parseInt;

public final class ConnectionPool implements com.epam.redball.dao.ConnectionPool {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static volatile ConnectionPool instance;
    private ResourceBundle properties = ResourceBundle.getBundle("ConnectionPool");
    private final int POOL_SIZE = parseInt(properties.getString("db.poolSize"));
    private BlockingQueue<Connection> connectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);
    private String url;
    private String user;
    private String password;
    private String driverName;

    private ConnectionPool() {
        init();
    }

    private void init() {
        setDataForConnection();
        loadDrivers();
        initPoolData();
    }

    private void setDataForConnection() {
        this.driverName = properties.getString("db.driver");
        this.url = properties.getString("db.url");
        this.user = properties.getString("db.user");
        this.password = properties.getString("db.password");
    }

    private void loadDrivers() {
        try {
            Driver driver = (Driver) Class.forName(driverName).newInstance();
        } catch (InstantiationException | ClassNotFoundException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            LOGGER.warn(e);
        }
    }

    private void initPoolData() {
        Connection connection;

        while (connectionQueue.size() < POOL_SIZE) {
            try {
                connection = DriverManager.getConnection(url, user, password);
                connectionQueue.put(connection);
            } catch (InterruptedException | SQLException e) {
                LOGGER.warn(e);
                e.printStackTrace();
            }
        }
    }

    public static ConnectionPool getInstance() {

        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
        return connection;
    }

    @Override
    public void releaseConnection(Connection connection) {
        if ((connection != null) && (connectionQueue.size() <= POOL_SIZE)) {
            try {
                connectionQueue.put(connection);
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }
    }
}
