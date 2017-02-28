package com.coolnimesh43.webservice.web.service.impl;

import java.net.URI;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.coolnimesh43.webservice.web.constant.WebServiceProperties;
import com.coolnimesh43.webservice.web.dto.SignInDTO;
import com.coolnimesh43.webservice.web.dto.SignInResponse;
import com.coolnimesh43.webservice.web.service.AuthenticationService;
import com.coolnimesh43.webservice.web.util.WebUtil;

@Service
@Lazy
public class AuthenticationServiceImpl implements AuthenticationService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private RestTemplateServiceImpl restTemplateServiceImpl;

    @Inject
    private WebServiceProperties webServiceProperties;

    public SignInResponse authenticateUser(String userName, String password) {
        log.debug("Authentication service called.");
        try {
            String authURL = WebUtil.constructURL(this.webServiceProperties.getInstance().getPersistence().getName(), "/api/authenticate");
            log.debug("authentication url is: {}", authURL);
            HttpHeaders headers = WebUtil.getDefaultHeader();
            RequestEntity<SignInDTO> signInRequest =
                    new RequestEntity<SignInDTO>(new SignInDTO(userName, password), HttpMethod.POST, new URI(authURL));

            ResponseEntity<?> sign =
                    this.restTemplateServiceImpl.post(signInRequest, authURL, new ParameterizedTypeReference<SignInResponse>() {
                    }, new Object[1]);
            if (sign != null) {
                return (SignInResponse) sign.getBody();
            }
        } catch (Exception e) {
            log.error("Excpetion while getting authentication data. Exception is: {}", e);
        }
        throw new BadCredentialsException("Invalid username or password.");
    }

}
