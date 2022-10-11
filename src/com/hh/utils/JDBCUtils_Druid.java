package com.hh.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

public class JDBCUtils_Druid {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("F:/javaweb/book/src/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }

    public static void close(ResultSet set, Connection connect, Statement statement) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connect != null) {
            try {
                connect.close();
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
