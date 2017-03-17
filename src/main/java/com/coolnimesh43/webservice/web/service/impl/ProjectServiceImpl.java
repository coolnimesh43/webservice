package com.coolnimesh43.webservice.web.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.coolnimesh43.webservice.web.constant.WebServiceConstant;
import com.coolnimesh43.webservice.web.constant.WebServiceProperties;
import com.coolnimesh43.webservice.web.dto.SignInResponse;
import com.coolnimesh43.webservice.web.model.Project;
import com.coolnimesh43.webservice.web.service.ProjectService;
import com.coolnimesh43.webservice.web.util.WebUtil;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private RestTemplateServiceImpl restTemplateServiceImpl;

    @Inject
    private WebServiceProperties webServiceProperties;

    public List<Project> findAllByCurrentUser() {
        String userURL = WebUtil.constructURL(this.webServiceProperties.getInstance().getPersistence().getName(), "/api/project/user");
        String token = ((SignInResponse) SecurityContextHolder.getContext().getAuthentication().getDetails()).getToken().getToken();
        try {
            RequestEntity<Void> request = RequestEntity.get(new URI(userURL)).accept(MediaType.APPLICATION_JSON)
                    .header(WebServiceConstant.Auth.X_AUTH_TOKEN, token).build();
            ResponseEntity<List<Project>> response = (ResponseEntity<List<Project>>) this.restTemplateServiceImpl.get(request, userURL,
                    new ParameterizedTypeReference<List<Project>>() {
                    }, new Object[1]);
            return response != null ? response.getBody() : null;
        } catch (URISyntaxException e) {
            log.error("Exception while building uri for user request. exception is: {}", e);
        }
        return new ArrayList<Project>();
    }
}
