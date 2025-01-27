package com.spring_p1.factorial.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factorial")
public class FactorialRestController {
    @GetMapping("/{number}")
    public String getFactorial(@PathVariable int number) {
        return number >= 0
            ? Integer.toString(factorial(number))
            : "Number should be greater or equal to zero.";
    }

    public int factorial(int number) {
        return number <= 1 ? 1 : number * factorial(number - 1);
    }
}
