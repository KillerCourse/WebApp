package com.epam.redball.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnectorDeleteLater {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/firstschema";
    private static final String USER = "root";
    private static final String PASSWORD = "kik14051990";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}