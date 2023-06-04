package com.firstapp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryServlet extends HttpServlet {


    public void inti() throws ServletException {

    }


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) getServletContext().getAttribute("username");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("category.jsp");
        System.out.println(username);

        req.setAttribute("username", username);

        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
