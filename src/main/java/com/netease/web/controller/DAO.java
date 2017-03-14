package com.netease.web.controller;

import java.io.InputStream;
import java.sql.*;
import java.io.*;

/**
 * Created by zj on 2017/2/13.
 */

public class DAO {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL= "jdbc:mysql://localhost/cloud_study" ;
    static final String USER="zj";
    static final String PASSWORD="zjlearn";

    //使用JDBC的基本用法
    public static void helloworld() throws ClassNotFoundException {
        Connection conn=null;
        Statement stmt= null;
        ResultSet rs= null;

        //1.装载驱动
        Class.forName(JDBC_DRIVER);

        try{
            //2. 建立数据库连接
            conn= DriverManager.getConnection(DB_URL, USER, PASSWORD);

            //3. 执行SQL语句
            stmt=conn.createStatement();

            rs=stmt.executeQuery("select userName from  user");

            //4. 获取执行结果
            while(rs.next()){
                System.out.println(rs.getString("uerName"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(conn != null)
                    conn.close();   //可能会抛出异常 是因为
                if (stmt != null)
                    stmt.close();
                if (rs != null )
                    rs.close();;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    //使用游标的方式 使用JDBC
    public static void helloworldV2() throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ptmt = null;  //为游标功能准备
        ResultSet rs = null;

        //1.装载驱动
        Class.forName(JDBC_DRIVER);

        try {
            //2. 建立数据库连接
            String DB_URLV2 = DB_URL + "useCursorFetch=true"; //游标
            conn = DriverManager.getConnection(DB_URLV2, USER, PASSWORD);

            //3. 执行SQL语句
            ptmt = conn.prepareStatement("select userName from  user");
            ptmt.setFetchSize(5);  //每次读取5个记录
            rs = ptmt.executeQuery();

            //4. 获取执行结果
            while (rs.next()) {
                System.out.println(rs.getString("uerName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();   //可能会抛出异常 是因为
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
                ;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    //使用流方式读取大数据
    public static void helloworldV3() throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ptmt = null;  //为游标功能准备
        ResultSet rs = null;

        //1.装载驱动
        Class.forName(JDBC_DRIVER);

        try {
            //2. 建立数据库连接
            String DB_URLV2 = DB_URL + "useCursorFetch=true"; //游标
            conn = DriverManager.getConnection(DB_URLV2, USER, PASSWORD);

            //3. 执行SQL语句
            ptmt = conn.prepareStatement("select userName from  user");
            ptmt.setFetchSize(5);  //每次读取5个记录
            rs = ptmt.executeQuery();

            //4. 获取执行结果
            while (rs.next()) {
                //获取对象流
                InputStream in= rs.getBinaryStream("blog");
                //将对象流写入文件
                File f= new File("D://result.txt");
                OutputStream out=null;
                try{
                    out=new FileOutputStream(f);
                    int temp=0;
                    while((temp =in.read())!=-1){
                        out.write(temp);
                    }
                    in.close();
                    out.close();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();   //可能会抛出异常 是因为
                if (stmt != null)
                    stmt.close();
                if (rs != null)
                    rs.close();
                ;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    //例子： 批处理插入

    //例子： 数据库连接池
    //使用的技术包括了：DBCP 也就是common DBCP连接。包含了三个jar包


}
