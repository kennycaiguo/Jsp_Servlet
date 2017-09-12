package com.exam.servlet;

import com.exam.dao.FilmDao;
import com.exam.dao.impl.FilmDaoImpl;
import com.exam.entity.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditFilm",urlPatterns = {"/edit"})
public class EditFilm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int filmId = Integer.parseInt(req.getParameter("filmId"));
        System.out.println("要编辑的filmId"+filmId);
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int languageId = Integer.parseInt(req.getParameter("language"));
        Film film = new Film();
        film.setFilmId(filmId);
        film.setTitle(title);
        film.setDescription(description);
        film.setLangusgeId(languageId);
        FilmDao filmDao = new FilmDaoImpl();
        filmDao.editFilm(film);
        List<Film> films = filmDao.showAll();
        req.setAttribute("films",films);
        req.getRequestDispatcher("film.jsp").forward(req,resp);
    }
}
