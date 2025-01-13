package com.example.romanNumbers.controller;

import com.example.romanNumbers.model.RomanNumbers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumbersController {

    @GetMapping("/roman/{number}")
    public String convert(@PathVariable int number) {
        return "El número romano es: " + RomanNumbers.toRoman(number);
    }
}
