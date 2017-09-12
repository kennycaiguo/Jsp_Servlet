package com.exam.servlet;

import com.exam.dao.CustomerDao;
import com.exam.dao.FilmDao;
import com.exam.dao.impl.CustomerDaoImpl;
import com.exam.dao.impl.FilmDaoImpl;
import com.exam.entity.Customer;
import com.exam.entity.Film;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginCheck", urlPatterns = {"/login"})
public class LoginCheck extends HttpServlet {
    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        System.out.println("FirstName:" + firstName);
        RequestDispatcher requestDispatcher = null;
        String forward = null;
        FilmDao filmDao = new FilmDaoImpl();
        if (customerDao.getOne(firstName)) {
            List<Film> films = filmDao.showAll();
            req.setAttribute("films",films);
            forward = "film.jsp";
        } else {
            req.setAttribute("msg", "该用户不存在！");
            forward = "login.jsp";
        }
        req.getRequestDispatcher(forward).forward(req, resp);
    }
}
