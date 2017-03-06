package com.coolnimesh43.webservice.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coolnimesh43.webservice.web.model.User;
import com.coolnimesh43.webservice.web.util.WebUtil;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView hello(HttpSession httpSession) {
        log.debug("Inside HomeController#hello.");
        log.debug("Authentication: {}", SecurityContextHolder.getContext().getAuthentication());
        ModelAndView modelAndView = new ModelAndView("hello");
        User user = WebUtil.getCurrentUser();
        if (user != null) {
            modelAndView.addObject("name", user.getFirstName());
        }
        return modelAndView;
    }
}
