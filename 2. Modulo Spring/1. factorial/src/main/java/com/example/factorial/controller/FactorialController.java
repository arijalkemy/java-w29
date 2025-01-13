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
        int factorial = 1;
        if (number >= 0)
        {
            if (number == 0)
                return "1";
            else {
                for (int i = 1; i <= number; i++) {
                    factorial *= i;
                }
                return String.valueOf(factorial);
            }

        }
        else
            return "Ingrese un número positivo";
    }
}
