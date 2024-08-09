package com.omergk.spring.playground.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient webClient(ApiClientConfiguration apiClientConfiguration) {
        return WebClient.builder().baseUrl(apiClientConfiguration.getBaseUrl()).build();
    }
}
