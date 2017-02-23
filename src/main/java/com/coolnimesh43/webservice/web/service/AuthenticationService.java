package com.coolnimesh43.webservice.web.service;

import com.coolnimesh43.webservice.web.dto.SignInResponse;

public interface AuthenticationService extends FeintClientInterface {

    SignInResponse authenticateUser(String userName, String password);

}
