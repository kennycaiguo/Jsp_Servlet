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

@WebServlet(name = "ToEditFilm",urlPatterns = {"/toEdit"})
public class ToEditFilm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int filmId = Integer.parseInt(req.getParameter("id"));
        FilmDao filmDao = new FilmDaoImpl();
        Film film = filmDao.selectOne(filmId);
        req.setAttribute("film",film);
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }
}
