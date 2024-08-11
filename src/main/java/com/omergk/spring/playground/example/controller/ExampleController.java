package com.omergk.spring.playground.example.controller;

import com.omergk.spring.playground.example.api.AirportApi;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/example")
@Validated
public class ExampleController {

    @Autowired private AirportApi airportApi;

    @GetMapping("/block/{airportCode}")
    @ResponseBody
    public String blockGet(@Valid @PathVariable("airportCode") @NotBlank String airportCode) {
        return airportApi.getAirportBlock(airportCode)
                + airportApi.getAirportBlock(airportCode)
                + airportApi.getAirportBlock(airportCode);
    }

    @GetMapping("/async")
    public String asyncGet() throws ExecutionException, InterruptedException {
        CompletableFuture<String> detroit = airportApi.getAirportAsync("DTW");
        CompletableFuture<String> apn = airportApi.getAirportAsync("APN");
        CompletableFuture<String> kctl = airportApi.getAirportAsync("KCTL");

        CompletableFuture.allOf(detroit, apn, kctl).join();

        return detroit.get() + apn.get() + kctl.get();
    }
}
