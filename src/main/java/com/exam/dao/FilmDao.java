package com.exam.dao;

import com.exam.entity.Film;

import java.util.List;

public interface FilmDao {
    public List<Film> showAll();
    public boolean addFilm(Film film);
    public boolean editFilm(Film film);
    public Film selectOne(int filmId);
    public boolean deleteFilm(int filmId);
}
