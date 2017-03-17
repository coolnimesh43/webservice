package com.coolnimesh43.webservice.web.service.impl;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coolnimesh43.webservice.web.constant.WebServiceConstant;
import com.coolnimesh43.webservice.web.constant.WebServiceProperties;
import com.coolnimesh43.webservice.web.model.User;
import com.coolnimesh43.webservice.web.service.UserService;
import com.coolnimesh43.webservice.web.util.WebUtil;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private RestTemplateServiceImpl restTemplateServiceImpl;

    @Inject
    private WebServiceProperties webServiceProperties;

    @Override
    public User getUserDetail(Long userId) {
        String userURL = WebUtil.constructURL(this.webServiceProperties.getInstance().getPersistence().getName(), "/api/user/id/{id}");
        String token = WebUtil.getAuthToken();
        try {
            RequestEntity<Void> request = RequestEntity.get(new URI(userURL)).accept(MediaType.APPLICATION_JSON)
                    .header(WebServiceConstant.Auth.X_AUTH_TOKEN, token).build();
            ResponseEntity<User> response =
                    (ResponseEntity<User>) this.restTemplateServiceImpl.get(request, userURL, new ParameterizedTypeReference<User>() {
                    }, userId);
            return response != null ? response.getBody() : null;
        } catch (URISyntaxException e) {
            log.error("Exception while building uri for user request. exception is: {}", e);
        }
        return null;
    }

}
