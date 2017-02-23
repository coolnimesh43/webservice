package com.coolnimesh43.webservice.web.dto;

public class SignInResponse extends GenericResponse {

    private Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SignInResponse [token=" + token + "]";
    }

}
