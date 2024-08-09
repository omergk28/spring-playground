package com.omergk.spring.playground.example.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class AirportApi {

    @Autowired
    private WebClient webClient;

    public String getAirportBlock(String airportCode) {
        return webClient.get().uri("/v1/airports?apt=" + airportCode).retrieve().bodyToMono(String.class).block();
    }


    @Async
    public CompletableFuture<String> getAirportAsync(String airportCode) {
        log.info("calling getAirportAsync {}", airportCode);
        return webClient.get().uri("/v1/airports?apt=" + airportCode).retrieve().bodyToMono(String.class).toFuture();
    }
}
