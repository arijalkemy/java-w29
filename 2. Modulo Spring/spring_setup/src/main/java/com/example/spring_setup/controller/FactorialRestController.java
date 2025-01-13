package com.example.spring_setup.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialRestController {
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    @GetMapping("/factorial/{number}")
    public String factorialEndpoint(@PathVariable int number) {
        return "The factorial of " + number + " is " + factorial(number);
    }
}
