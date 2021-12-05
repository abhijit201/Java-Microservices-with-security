package com.olx.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OlxApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxApiGateWayApplication.class, args);
	}

}
