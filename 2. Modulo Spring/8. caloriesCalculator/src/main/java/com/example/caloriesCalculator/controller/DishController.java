package com.example.caloriesCalculator.controller;

import com.example.caloriesCalculator.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/dishes")
public class DishController {
    private final DishService dishService;

    @RequestMapping("/calories/{name}")
    public ResponseEntity<String> getAmountOfCalories(@PathVariable String name) {
        return new ResponseEntity<>(dishService.getAmountOfCalories(name), HttpStatus.OK);
    }
}
