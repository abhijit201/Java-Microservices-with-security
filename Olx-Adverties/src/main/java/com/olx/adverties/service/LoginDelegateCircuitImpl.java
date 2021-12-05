package com.olx.adverties.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class LoginDelegateCircuitImpl implements LoginDelegate{

	
	@Autowired
	RestTemplate restTemplate;
	
//	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	
	@Override
	@CircuitBreaker(name = "AUTH_TOKEN_VALIDATION" , fallbackMethod = "fallbackForIsValidTokenStatus" )
	public boolean isValidToken(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Boolean> result = this.restTemplate.exchange("http://localhost:7000/userdetails/token/validate",
                HttpMethod.GET, entity, Boolean.class);
		
		return result.getBody();
	}
	
	public boolean fallbackForIsValidTokenStatus(String authToken, Throwable throwable) {
		System.out.println("Login service failed:"+throwable);
		return false;
	}

}
