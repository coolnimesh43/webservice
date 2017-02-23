package com.coolnimesh43.webservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessDeniedHandlerService {

    @RequestMapping(value = "/access-denied")
    public ModelAndView get() {
        return new ModelAndView("access-denied");
    }

}
