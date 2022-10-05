package com.hh.dao.impl;

import com.hh.utils.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object... parameter) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.connect();
            int affectedRow = queryRunner.update(connection, sql, parameter);
            return affectedRow;
        } catch (SQLException throwables) {
            throw new RuntimeException();
        } finally {
            JDBCUtils_Druid.close(null, connection, null);
        }
    }

    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameter) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.connect();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), parameter);
        } catch (SQLException throwables) {
            throw new RuntimeException();
        } finally {
            JDBCUtils_Druid.close(null, connection, null);
        }
    }

    public T querySingle(String sql, Class<T> clazz, Object... parameter) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.connect();
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), parameter);
        } catch (SQLException throwables) {
            throw new RuntimeException();
        } finally {
            JDBCUtils_Druid.close(null, connection, null);
        }
    }

    public Object queryScalar(String sql, Object... parameter) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.connect();
            return queryRunner.query(connection, sql, new ScalarHandler(), parameter);
        } catch (SQLException throwables) {
            throw new RuntimeException();
        } finally {
            JDBCUtils_Druid.close(null, connection, null);
        }
    }
}
