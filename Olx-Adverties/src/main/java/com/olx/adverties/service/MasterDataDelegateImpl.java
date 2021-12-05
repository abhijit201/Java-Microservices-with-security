package com.olx.adverties.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.olx.adverties.dto.Category;
import com.olx.adverties.dto.Status;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MasterDataDelegateImpl implements MasterDataDelegate{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	@CircuitBreaker(name = "STATUS-FROM-MASTER-DATA-SERVICE", fallbackMethod = "fallbackStatusMasterData")
	public Status getStatusById(int statusId) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Status> result = restTemplate.exchange("http://localhost:9002/olx/advertise/status/"+statusId,
		                                HttpMethod.GET, entity, new ParameterizedTypeReference<Status>() {});
		return result.getBody();
		
		// with object only
//		String responseStatusText = this.restTemplate.getForObject("http://localhost:9002/olx/advertise/status" + statusId,String.class);
//		return responseStatusText;
		
		// with response 
//		ResponseEntity<String> responseStatusText = this.restTemplate.getForEntity("http://localhost:8080/olx/status" + statusId,String.class);
//		return responseStatusText.getBody();
	} 
	
	public String fallbackStatusMasterData(int statusId,Exception e) {
	System.out.println("fallbackStatusMasterData EROOROOROR" +e);
	return null;
	}

	@Override
	@CircuitBreaker(name = "CATEGORY-FROM-MASTER-DATA-SERVICE", fallbackMethod = "fallbackCategoryMasterData")
	public Category getCategoryById(int categoryId) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Category> result = restTemplate.exchange("http://localhost:9002/olx/advertise/category/"+categoryId,
                HttpMethod.GET, entity, new ParameterizedTypeReference<Category>() {});

        return result.getBody();
	}
	
	public String fallbackCategoryMasterData(int statusId,Exception e) {
		
	System.out.println("fallbackCategoryMasterData EROOROOROR" +e);
	return null;
	}
}
