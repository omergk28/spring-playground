package com.omergk.spring.playground.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api.services")
@EnableConfigurationProperties
@Data
public class ApiClientConfiguration {
    private String name;
    private String baseUrl;
}
