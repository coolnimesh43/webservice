package com.coolnimesh43.webservice.web.dto;

import java.io.Serializable;

public class SignInDTO implements Serializable {

    private String login;
    private String password;

    public SignInDTO() {
        super();
    }

    public SignInDTO(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignInDTO [login=" + login + ", password=" + password + "]";
    }

}
