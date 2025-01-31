package com.example.ejemploSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello Spring";
    }

    @GetMapping("/sayHello2/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }
}
