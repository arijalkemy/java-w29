package com.firstproject.demo.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialRestController {

    @GetMapping("/factorial/{n}")
    public long factorialGet(@PathVariable long n) {
        return n == 1 ? 1 : n * factorialGet(n - 1);
    }
}
