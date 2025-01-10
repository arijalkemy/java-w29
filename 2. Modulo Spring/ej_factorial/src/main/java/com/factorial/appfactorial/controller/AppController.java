package com.factorial.appfactorial.controller;

import com.factorial.appfactorial.service.FactorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AppController {

    private final FactorialService factorialService;

    @Autowired
    public AppController(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    @GetMapping("/factorial/{number}")
    public Long factorial(@PathVariable Integer number) {
        return factorialService.calculateFactorial(number);
    }
}
