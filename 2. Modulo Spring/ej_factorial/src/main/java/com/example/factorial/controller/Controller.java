package com.example.factorial.controller;

import com.example.factorial.service.FactorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final FactorialService service;

    @Autowired
    public Controller(FactorialService service) {
        this.service = service;
    }

    @GetMapping("/factorial/{num}")
    public ResponseEntity<?> factorial(@PathVariable Integer num) {
        try {
            return ResponseEntity.ok(service.calcularFactorial(num));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
