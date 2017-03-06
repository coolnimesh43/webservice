package com.coolnimesh43.webservice.web.util;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.coolnimesh43.webservice.web.dto.SignInResponse;
import com.coolnimesh43.webservice.web.model.User;

public class WebUtil {

    public static String constructURL(String instance, String requestURL) {
        return "http://" + instance + requestURL;
    }

    public static HttpHeaders getDefaultHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return headers;
    }

    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getDetails();
        if (details instanceof SignInResponse) {
            SignInResponse dto = (SignInResponse) details;
            return dto.getUser();
        }
        return null;
    }
}
