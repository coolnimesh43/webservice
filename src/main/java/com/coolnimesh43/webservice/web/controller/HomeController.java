package com.coolnimesh43.webservice.web.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coolnimesh43.webservice.web.dto.SignInDTO;
import com.coolnimesh43.webservice.web.service.AuthenticationService;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView hello(@RequestBody SignInDTO signInDTO) {
        log.debug("Inside HomeController#hello.");
        this.authenticationService.authenticateUser(signInDTO.getLogin(), signInDTO.getPassword());
        return null;
    }
}
