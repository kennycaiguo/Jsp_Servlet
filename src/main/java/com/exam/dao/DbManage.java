package com.exam.dao;

import java.sql.*;

public class DbManage {
    //驱动名称
    private  static String driver = "com.mysql.jdbc.Driver";
    //数据库地址
    private static String url = "jdbc:mysql://localhost:3306/sakila";
    //数据库用户名
    private static String name = "root";
    //数据库密码
    private static String password = "";
    //数据库连接接
    private static Connection conn = null;

    public Connection getConn() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,name,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public void closeDB(ResultSet resultSet,PreparedStatement preparedStatement, Connection conn){
        try {
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeDB(PreparedStatement preparedStatement, Connection conn){
        try {
            preparedStatement.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
