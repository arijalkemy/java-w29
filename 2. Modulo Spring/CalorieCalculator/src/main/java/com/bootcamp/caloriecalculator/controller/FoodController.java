package com.bootcamp.caloriecalculator.controller;

import com.bootcamp.caloriecalculator.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calories")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping("dish/{name}/amount/{amount}")
    public ResponseEntity<?> getCalories(@PathVariable String name, @PathVariable int amount) {
        return ResponseEntity.ok(foodService.getCalories(name, amount));
    }

    @GetMapping("dish/{name}/composition")
    public ResponseEntity<?> getDishComposition(@PathVariable String name) {
        return ResponseEntity.ok(foodService.getDishComposition(name));
    }

    @GetMapping("dish/{name}/highest-calorie")
    public ResponseEntity<?> getHighestCalorie(@PathVariable String name) {
        return ResponseEntity.ok(foodService.getHighestCalorie(name));
    }

}
