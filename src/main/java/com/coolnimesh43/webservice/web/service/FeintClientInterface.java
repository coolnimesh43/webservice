package com.coolnimesh43.webservice.web.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("persistence-service")
public interface FeintClientInterface {

}
