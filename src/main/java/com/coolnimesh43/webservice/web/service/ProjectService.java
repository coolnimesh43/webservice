package com.coolnimesh43.webservice.web.service;

import java.util.List;

import com.coolnimesh43.webservice.web.model.Project;

public interface ProjectService {

    List<Project> findAllByCurrentUser();
}
