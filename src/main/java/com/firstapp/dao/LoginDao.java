package com.firstapp.dao;

import javax.servlet.ServletContext;
import java.sql.*;

public class LoginDao {

    public boolean verifyLogin(String username, String password, ServletContext servletContext) {

        String mysqlDbUrl = servletContext.getInitParameter("db.mysql.url");
        String mysqlDbdriver = servletContext.getInitParameter("db.mysql.driver");
        String dbUsername = servletContext.getInitParameter("db.mysql.username");
        String dbPassword = servletContext.getInitParameter("db.mysql.password");


        System.out.println(mysqlDbUrl);
        System.out.println(mysqlDbdriver);
        System.out.println(dbUsername);
        System.out.println(dbPassword);
        String authPassword = null;
        Connection conn = null;
        try {
            //    1. Load the Drivers
            Class.forName(mysqlDbdriver).newInstance();

            // 2. Establish the Connection with DB using URL, username, password
            conn = DriverManager.getConnection(mysqlDbUrl, dbUsername, dbPassword);
            // 3. Prepare the statements
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM user_login WHERE username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // 4. execute the statement
            ResultSet rs = preparedStatement.executeQuery();
            //5. Extract data from result sets
            if (rs.next()) {
                //      circle = new batch.four.Circle(1, rs.getString("name"));
                authPassword = rs.getString("password");
            }
            //  6. Close the connection.
            rs.close();

            if(null != authPassword){
                return authPassword.equals(password);
            }
            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
