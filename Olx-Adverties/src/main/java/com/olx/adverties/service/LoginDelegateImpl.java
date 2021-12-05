package com.olx.adverties.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class LoginDelegateImpl implements LoginDelegate{
	
	@Autowired
	RestTemplate restTemplate;
	
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Override
	public boolean isValidToken(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		HttpEntity entity = new HttpEntity(headers);
		try {
		ResponseEntity<Boolean> result =this.restTemplate.exchange("http://localhost:9001/userdetails/token/validate",
		                                HttpMethod.GET, entity, Boolean.class);
		if(result.getStatusCode()==HttpStatus.OK)
		{
			return result.getBody();
		}
		else {
			return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

}
