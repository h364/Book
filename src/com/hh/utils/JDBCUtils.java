package com.hh.utils;

import java.sql.*;

public class JDBCUtils {
    private static String user;
    private static String password;
    private static String url;

    static {
        user = "root";
        password = "123456";
        url = "jdbc:mysql://localhost:3306/hh_db01?rewriteBatchedStatements=true";
    }

    public Connection connect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }

    public void close(Statement statement, Connection connection, ResultSet set) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
