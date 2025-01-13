package com.mercadolibre.javawave29.romannumbers.controller;

import com.mercadolibre.javawave29.romannumbers.service.RomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumbersController {

    private final RomanService service;

    @Autowired
    public RomanNumbersController(RomanService service) {
        this.service = service;
    }

    @GetMapping("/romanNumbers/{decimalNumber}")
    public String romanNumbers(@PathVariable int decimalNumber) {
        return service.toRoman(decimalNumber);
    }
}
