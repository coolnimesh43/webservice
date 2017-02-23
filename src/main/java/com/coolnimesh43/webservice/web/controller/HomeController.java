package com.coolnimesh43.webservice.web.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello() {
        log.debug("Inside HomeController#hello. ");
        ModelAndView modelAndView = new ModelAndView("hello", Collections.singletonMap("name", "nimesh"));
        return modelAndView;
    }
}
