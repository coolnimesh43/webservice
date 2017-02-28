package com.coolnimesh43.webservice.web.dto;

/**
 * The security token.
 */
public class Token {

    String token;
    long expires;

    public Token() {
        super();
    }

    public Token(String token, long expires) {
        this.token = token;
        this.expires = expires;
    }

    public String getToken() {
        return token;
    }

    public long getExpires() {
        return expires;
    }
}
