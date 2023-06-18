package com.firstapp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryServlet extends HttpServlet {


    public void inti() throws ServletException {

    }


    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String username = (String) httpServletRequest.getSession().getAttribute("user");
        Cookie cookie1 = new Cookie("username", username);
        if (null != username) {
            httpServletResponse.addCookie(cookie1);
            httpServletRequest.setAttribute("username", username);
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("category.jsp");
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute("errorMessage", "Invalid User, please login again");
            RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(httpServletRequest, httpServletResponse);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
