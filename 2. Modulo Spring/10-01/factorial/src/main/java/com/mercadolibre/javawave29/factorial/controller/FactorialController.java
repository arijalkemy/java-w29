package com.mercadolibre.javawave29.factorial.controller;


import com.mercadolibre.javawave29.factorial.service.FactorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    private final FactorialService factorialService;

    @Autowired
    public FactorialController(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    @GetMapping("/factorial/{numero}")
    public String factorial(@PathVariable Long numero) {
        return factorialService.factorial(numero);
    }
}
