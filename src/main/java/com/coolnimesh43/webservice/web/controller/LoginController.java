package com.coolnimesh43.webservice.web.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coolnimesh43.webservice.web.dto.SignInDTO;
import com.coolnimesh43.webservice.web.service.AuthenticationService;

@Controller
// @RequestMapping("/login")
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView authenticate(@ModelAttribute SignInDTO signInDTO) {
        log.debug("Inside login controller. Signin is: {}", signInDTO);
        ModelAndView modelAndView = new ModelAndView("login");
        // try {
        // SignInResponse response = this.authenticationService.authenticateUser(signInDTO.getLogin(), signInDTO.getPassword());
        // log.debug("Autentication successful: {}", response);
        // } catch (BadCredentialsException e) {
        // log.error("Bad credentials while authenticating user. Exception is: {}", e);
        // modelAndView.addObject("error", "Invalid username or password");
        // } catch (Exception e) {
        // log.error("Exceptin while authenticating user. Exception is: {}", e);
        // modelAndView.addObject("error", "Error occurred while authenticating user.");
        // }
        modelAndView.addObject("success", Boolean.TRUE);
        return modelAndView;
    }
}
