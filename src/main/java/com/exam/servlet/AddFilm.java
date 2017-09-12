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

@WebServlet(name = "AddFilm",urlPatterns = {"/insert"})
public class AddFilm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int language_id = Integer.parseInt(req.getParameter("language"));
        System.out.println(language_id);
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setLangusgeId(language_id);
        FilmDao filmDao = new FilmDaoImpl();
        boolean flag = filmDao.addFilm(film);
        System.out.println(flag);
        req.setAttribute("msg","添加成功");
        req.getRequestDispatcher("add.jsp").forward(req,resp);
    }
}
