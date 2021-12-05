package com.olx;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.olx.entity.ExpiredToken;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class OlxLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxLoginApplication.class, args);
	}
	
	@Bean
    public Docket getCustomizedDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.olx"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "OLX Application Api Document",
                "Api documentation for OLX App - Login service",
                "1.0",
                "",
                new Contact("Abhi", "", "Abhi@zensar.com"),
                "GPL",
                "www.gpl.com",
                new ArrayList<>()
        );
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public RedisTemplate<Long, ExpiredToken> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<Long, ExpiredToken> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        return template;
//    }

}
