package com.coolnimesh43.webservice.config.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.coolnimesh43.webservice.web.service.AuthenticationService;

@Component(value = "customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Inject
    private AuthenticationService authenticationService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}
