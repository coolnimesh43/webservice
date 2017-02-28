package com.coolnimesh43.webservice.web.util;

import org.springframework.http.HttpHeaders;

public class WebUtil {

    public static String constructURL(String instance, String requestURL) {
        return "http://" + instance + requestURL;
    }

    public static HttpHeaders getDefaultHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return headers;
    }
}
