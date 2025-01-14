package com.example.calculofactorial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculoFactorial {

    @GetMapping("/numero/{n}")
    public String factorial(@PathVariable int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }
        Long resultado = 1L;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return "El numero factorial de " + n + " es:" + resultado.toString();

    }
}
