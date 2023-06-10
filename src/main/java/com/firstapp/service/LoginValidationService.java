package com.firstapp.service;

import com.firstapp.dao.LoginDao;

import javax.servlet.ServletContext;

public class LoginValidationService {

    private LoginDao loginDao = null;
    public boolean isValidUSer(String username, String password, ServletContext servletContext) {
        loginDao = new LoginDao();
        return loginDao.verifyLogin(username, password, servletContext);

    }
}
