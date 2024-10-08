package com.omergk.spring.playground.example.api;

import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class AirportApi {

    private final WebClient webClient;

    public AirportApi(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getAirportBlock(String airportCode) {
        log.info("calling getAirportBlock {}", airportCode);
        return webClient
                .get()
                .uri("/v1/airports?apt=" + airportCode)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @Async
    public CompletableFuture<String> getAirportAsync(String airportCode) {
        log.info("calling getAirportAsync {}", airportCode);
        return webClient
                .get()
                .uri("/v1/airports?apt=" + airportCode)
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();
    }
}
