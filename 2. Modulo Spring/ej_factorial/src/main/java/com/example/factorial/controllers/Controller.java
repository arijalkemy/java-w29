package com.example.factorial.controllers;

import com.example.factorial.services.FactorialService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final FactorialService service;

    @GetMapping("/factorial/{num}")
    public ResponseEntity<?> factorial(
            @Positive @Max(value = 5000, message = "El número máximo es 5000") @PathVariable Integer num) {
        return ResponseEntity.ok(service.factorial(num));
    }
}
