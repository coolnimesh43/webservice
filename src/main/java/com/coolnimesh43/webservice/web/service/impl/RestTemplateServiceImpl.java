package com.coolnimesh43.webservice.web.service.impl;

import javax.inject.Inject;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateServiceImpl {

    @Inject
    private RestTemplate restTemplate;

    public ResponseEntity<?> post(RequestEntity<?> requestEntity, String url, ParameterizedTypeReference<?> parameterizedTypeReference,
            Object... uriVariables) throws RestClientException {
        ResponseEntity<?> response =
                this.restTemplate.exchange(url, HttpMethod.POST, requestEntity, parameterizedTypeReference, uriVariables);
        return response;
    }

    public ResponseEntity<?> get(RequestEntity<?> requestEntity, String url, ParameterizedTypeReference<?> parameterizedTypeReference,
            Object... uriVariables) throws RestClientException {
        ResponseEntity<?> response =
                this.restTemplate.exchange(url, HttpMethod.GET, requestEntity, parameterizedTypeReference, uriVariables);
        return response;
    }
}
