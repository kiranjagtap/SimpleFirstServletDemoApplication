package com.firstapp.controller;


import com.firstapp.service.LoginValidationService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    private String mysqlDbUrl = null;
    private String mysqlDbdriver = null;
    private String username = null;
    private String password = null;
    ServletContext servletContext = null;

    LoginValidationService loginValidationService = null;

    public void init() throws ServletException {
        servletContext = getServletContext();
        loginValidationService = new LoginValidationService();
    }

    @Override
    public void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Request received");
        System.out.println("mysqlDbUrl = " + mysqlDbUrl);

        String username = (String) servletRequest.getParameter("username");
        String password = (String) servletRequest.getParameter("password");


        if (loginValidationService.isValidUSer(username, password, servletContext)) {
            getServletContext().setAttribute("username", username);
            servletRequest.setAttribute("user", username);

            HttpSession httpSession = servletRequest.getSession();

            httpSession.setAttribute("user",username);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("welcome.jsp");
            requestDispatcher.forward(servletRequest, servletResponse);

        } else {
            servletRequest.setAttribute("errorMessage", "Invalid Credentials. Please try again !!!");
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(servletRequest, servletResponse);

        }


    }
}
