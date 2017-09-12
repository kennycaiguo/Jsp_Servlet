package com.exam.dao.impl;

import com.exam.dao.DbManage;
import com.exam.dao.FilmDao;
import com.exam.entity.Film;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDaoImpl implements FilmDao {
    DbManage dbManage = new DbManage();
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String sql = null;

    @Override
    public List<Film> showAll() {
        List<Film> films = new ArrayList<Film>();
        conn = dbManage.getConn();
        sql = "select f.film_id,f.title,f.description,l.name from film f left join language l on f.language_id = l.language_id";
        try {
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Film film = new Film();
                film.setFilmId(resultSet.getInt(1));
                film.setTitle(resultSet.getString(2));
                film.setDescription(resultSet.getString(3));
                film.setName(resultSet.getString(4));
                films.add(film);            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbManage.closeDB(resultSet,preparedStatement,conn);
        }
        return films;
    }

    @Override
    public boolean addFilm(Film film) {
        conn = dbManage.getConn();
        String sql = "INSERT INTO film(title,description,language_id) VALUES (?,?,?)";
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,film.getTitle());
            preparedStatement.setString(2,film.getDescription());
            preparedStatement.setInt(3,film.getLangusgeId());
            int count = preparedStatement.executeUpdate();
            System.out.println("添加"+count);
            System.out.println(count);
            return count>0?true:false;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbManage.closeDB(preparedStatement,conn);
        }
        return false;
    }

    @Override
    public boolean editFilm(Film film) {
        conn = dbManage.getConn();
        String sql = "UPDATE film SET title = ?,description=?,language_id=? WHERE film_id=?;";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,film.getTitle());
            preparedStatement.setString(2,film.getDescription());
            preparedStatement.setInt(3,film.getLangusgeId());
            preparedStatement.setInt(4,film.getFilmId());
            int count = preparedStatement.executeUpdate();
            System.out.println("修改"+count);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbManage.closeDB(preparedStatement,conn);
        }
        return false;
    }

    @Override
    public Film selectOne(int filmId) {
        conn = dbManage.getConn();
        Film film = new Film();
        String sql = "select film_id,title,description,language_id from film where film_id = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,filmId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                film.setFilmId(resultSet.getInt(1));
                film.setTitle(resultSet.getString(2));
                film.setDescription(resultSet.getString(3));
                film.setLangusgeId(resultSet.getInt(4));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbManage.closeDB(resultSet,preparedStatement,conn);
        }
        return film;
    }

    @Override
    public boolean deleteFilm(int filmId) {
        conn = dbManage.getConn();
        String sql = "delete from film where film_id = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,filmId);
            int count = preparedStatement.executeUpdate();
            System.out.println("删除"+count);
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbManage.closeDB(preparedStatement,conn);
        }
        return false;
    }
}
