package com.firstapp.controller;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    private String mysqlDbUrl = null;

    /*  private String drive = "com.mysql.cj.jdbc.Driver";
      private String username = "admin";
      private String password = "root";*/
    public void init() throws ServletException {
        //mysqlDbUrl = getInitParameter("db.mysql");
        ServletContext servletContext = getServletContext();
        mysqlDbUrl = servletContext.getInitParameter("db.mysql");
    }

    @Override
    public void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Request received");
        System.out.println("mysqlDbUrl = " + mysqlDbUrl);

        String username = (String) servletRequest.getParameter("username");
        String password = (String) servletRequest.getParameter("password");


        if (username.equals("sachin") && password.equals("sachin")) {
            getServletContext().setAttribute("username", username);

           /* PrintWriter pw  = servletResponse.getWriter();
            pw.write("<html>");
            pw.write("<body>");
            pw.write("<h1>Hello Welcome "+username+"</h1>");
            pw.write("</body>");
            pw.write("</html>");*/

            servletRequest.setAttribute("user", username);

            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("welcome.jsp");
            requestDispatcher.forward(servletRequest, servletResponse);

        } else {

            /*PrintWriter pw  = servletResponse.getWriter();
            pw.write("<html>");
            pw.write("<body>");
            pw.write("<h1>Invalid Credentials. Please try again !!!</h1>");
            pw.write("</body>");
            pw.write("</html>");*/

            servletRequest.setAttribute("errorMessage", "Invalid Credentials. Please try again !!!");
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(servletRequest, servletResponse);

        }


    }
}
