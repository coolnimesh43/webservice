package com.coolnimesh43.webservice.web.dto;

import com.coolnimesh43.webservice.web.model.User;

public class SignInResponse extends GenericResponse {

    private Token token;
    private User user;

    public SignInResponse() {
        super();
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SignInResponse [token=" + token + ", user=" + user + "]";
    }

}
