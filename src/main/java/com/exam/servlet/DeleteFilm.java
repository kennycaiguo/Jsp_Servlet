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

@WebServlet(name = "DeleteFilm",urlPatterns = {"/delete"})
public class DeleteFilm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int filmId = Integer.parseInt(req.getParameter("id"));
        FilmDao filmDao = new FilmDaoImpl();
        filmDao.deleteFilm(filmId);
        List<Film> films = filmDao.showAll();
        req.setAttribute("films",films);
        req.getRequestDispatcher("film.jsp").forward(req,resp);
    }
}
