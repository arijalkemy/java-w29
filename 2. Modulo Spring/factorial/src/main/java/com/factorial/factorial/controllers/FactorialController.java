package com.factorial.factorial.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcular")
public class FactorialController {
    @GetMapping("/{numero}")
    public String calcularFactorial(@PathVariable Integer numero){
        return "el factorial de: " + numero + " es: " + factorial(numero);
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        return (n == 0 || n == 1) ? 1 : n * factorial(n - 1);
    }
}
