package com.exam.dao.impl;

import com.exam.dao.CustomerDao;
import com.exam.dao.DbManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDaoImpl implements CustomerDao {
    DbManage dbManage = new DbManage();
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = null;
    @Override
    public boolean getOne(String firstName) {
        conn = dbManage.getConn();
        sql = "select first_name from customer where first_name = ?";
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,firstName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbManage.closeDB(resultSet,preparedStatement,conn);
        }
        return false;
    }
}
