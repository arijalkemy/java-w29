package com.meli.ej_edad.controller;

import com.meli.ej_edad.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
public class AppController {

    private final AgeService ageService;

    @Autowired
    public AppController(AgeService ageService) {
        this.ageService = ageService;
    }

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAge(
            @PathVariable Integer day,
            @PathVariable Integer month,
            @PathVariable Integer year) {
        Integer age = this.ageService.calculateAge(day, month, year);
        return ResponseEntity.ok(age);
    }
}
