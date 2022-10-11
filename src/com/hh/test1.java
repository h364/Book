package com.hh;

import com.hh.utils.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class test1 {
    @Test
    public void useDbUtils() throws SQLException {
        Connection connection = JDBCUtils_Druid.connect();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update user set balance = 10000 where id = ?";
        int affectRows = queryRunner.update(connection, sql, 1);
        System.out.println(affectRows > 0 ? "执行成功":"执行失败");
        JDBCUtils_Druid.close(null, connection,null);
    }
}
