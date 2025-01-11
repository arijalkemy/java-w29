package com.ejercicio_calculo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculoController {

    @GetMapping
    public String home() {
        return "<a href='/numero/5'>/numero/5</a></p>";
    }

    @GetMapping("/numero/{n}")
    public String factorial(@PathVariable int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }
        Long resultado = 1L;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado.toString();
    }
}
