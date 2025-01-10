package com.example.factorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factorial")
public class FactorialController {

    @GetMapping("/{number}")
    public String getFactorial(@PathVariable int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return "El factorial de " + number + " es: " + result;
    }
}
