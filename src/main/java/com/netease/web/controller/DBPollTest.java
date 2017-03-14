package com.netease.web.controller;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zj on 2017/2/15.
 */
//
public class DBPollTest {
    public static BasicDataSource ds = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/cloud_study";
    static final String USER = "zj";
    static final String PASSWORD = "zjlearn";

    public static void dbpoolinit() {
        ds = new BasicDataSource();
        ds.setUrl(DB_URL);
        ds.setDriverClassName(JDBC_DRIVER);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
    }

    public void dbPoolTest() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        //获取物理连接
        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * form user");
            while (rs.next()) {
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();  //和原有的JDBC关闭不太一样
            } catch (SQLException e) {
                e.printStackTrace();
                ;
            }
        }
    }

}
