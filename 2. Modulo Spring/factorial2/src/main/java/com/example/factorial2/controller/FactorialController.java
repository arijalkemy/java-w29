package com.example.factorial2.controller;

import com.example.factorial2.service.FactorialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    FactorialService factorialService;

    public FactorialController() {
        this.factorialService = new FactorialService();
    }

    @GetMapping("/{base}")
    public String factorial(@PathVariable Long base) {
        return this.factorialService.factorial(base).toString();
    }

}
