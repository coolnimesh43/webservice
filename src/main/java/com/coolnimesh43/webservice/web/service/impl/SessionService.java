package com.coolnimesh43.webservice.web.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.coolnimesh43.webservice.web.constant.WebServiceConstant;

@Component
@Scope("session")
public class SessionService {

    public HttpSession getSession() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attributes.getRequest().getSession(true);
        return session;
    }

    public String getUserToken() {
        HttpSession session = this.getSession();
        Object object = session.getAttribute(WebServiceConstant.Auth.AUTH_TOKEN);
        return object == null ? null : (String) object;
    }
}
