package com.omergk.spring.playground.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping(path = "/example")
public class ExampleController {

    @Autowired
    private WebClient webClient;


    @GetMapping
    public String example() {
        return webClient.get().uri("/v1/airports?" + "apt=AVL").retrieve().bodyToMono(String.class).block();
    }
}
