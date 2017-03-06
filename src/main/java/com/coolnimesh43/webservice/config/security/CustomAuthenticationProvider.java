package com.coolnimesh43.webservice.config.security;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.coolnimesh43.webservice.web.dto.SignInResponse;
import com.coolnimesh43.webservice.web.service.AuthenticationService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private AuthenticationService authenticationService;

    @Resource(name = "customUserDetailService")
    private UserDetailsService userDetailService;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("Inside custom authe");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) authentication;
        String login = usernamePasswordAuthenticationToken.getName();
        String tokenPassword = (String) usernamePasswordAuthenticationToken.getCredentials();
        try {
            SignInResponse response = this.authenticationService.authenticateUser(login, tokenPassword);
            if (response != null) {
                Collection<? extends GrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>() {
                    {
                        add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    }
                };
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(login, tokenPassword, authorities);
                authenticationToken.setDetails(response);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                return authenticationToken;

            }
        } catch (Exception e) {
            log.error("Exception while authentication user. Exception is: {}", e);
        }
        return null;
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
