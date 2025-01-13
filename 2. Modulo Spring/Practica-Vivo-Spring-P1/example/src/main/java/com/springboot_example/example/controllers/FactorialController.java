package com.springboot_example.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    @GetMapping("/factorial/{number}")
    public String calculateFactorial(@PathVariable int number) {
        if (number < 0) {
            return "Error: El número debe ser mayor o igual a 0.";
        }

        long result = factorial(number);
        return "El factorial de " + number + " es: " + result;
    }

    private long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
