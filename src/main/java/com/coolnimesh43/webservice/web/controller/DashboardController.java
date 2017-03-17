package com.coolnimesh43.webservice.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.coolnimesh43.webservice.web.model.Project;
import com.coolnimesh43.webservice.web.service.ProjectService;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        try {
            List<Project> projects = this.projectService.findAllByCurrentUser();
            modelAndView.addObject("projects", projects);
        } catch (Exception e) {
            log.error("Exception while getting models for dashboard. Exception is: {}", e);
        }
        return modelAndView;
    }
}
