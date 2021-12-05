package com.olx.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class OlxConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxConfigurationApplication.class, args);
	}

}
