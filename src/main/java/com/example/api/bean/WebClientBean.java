package com.example.api.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientBean {
	
	@Bean
	public WebClient webClientBean(WebClient.Builder builder) {
		return builder.baseUrl("https://viacep.com.br/ws/")
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.build();
		
	}
}
