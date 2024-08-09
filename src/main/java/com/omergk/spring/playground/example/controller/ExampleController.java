package com.omergk.spring.playground.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/example")
public class ExampleController {
    @GetMapping
    public String example() {
        System.out.println("ExampleController");
        return "Hello World!";
    }
}
