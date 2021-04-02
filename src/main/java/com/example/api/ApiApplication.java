package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableAutoConfiguration
public class ApiApplication {

	@Bean
	public WebClient webClientBean(WebClient.Builder builder) {
		return builder.baseUrl("https://viacep.com.br/ws/")
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.build();
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
