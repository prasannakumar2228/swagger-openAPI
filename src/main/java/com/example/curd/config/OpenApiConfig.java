package com.example.curd.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  //http://localhost:8080/swagger-ui/index.html

    @Bean
    GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("public").packagesToScan("com.example.curd") // Set your base package here
				.build();
	}
}
