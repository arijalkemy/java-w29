package com.spring.roman_numbers.controller;

import com.spring.roman_numbers.service.RomanNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roman")
public class RomanNumbersController {
    @Autowired
    RomanNumbersService romanNumbersService;

    @GetMapping("/{number}")
    public ResponseEntity<?> getRomanNumber(@PathVariable Integer number) {
        return ResponseEntity.ok(romanNumbersService.mapToRomanNumber(number));
    }
}
