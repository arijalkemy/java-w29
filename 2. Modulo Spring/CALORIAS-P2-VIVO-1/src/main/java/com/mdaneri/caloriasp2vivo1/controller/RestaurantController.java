package com.mdaneri.caloriasp2vivo1.controller;


import com.mdaneri.caloriasp2vivo1.dtos.DishDTO;
import com.mdaneri.caloriasp2vivo1.dtos.FoodDTO;
import com.mdaneri.caloriasp2vivo1.exception.FoodNotFoundException;
import com.mdaneri.caloriasp2vivo1.service.IDishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestaurantController {

    private final IDishService foodService;

    public RestaurantController(IDishService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/calories")
    public ResponseEntity<String> getDishCalories(@RequestParam String dishName) {
        try {
            Integer calories = foodService.getCalories(dishName);
            return ResponseEntity.ok(String.format("This dish has %d calories", calories));
        } catch (FoodNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/max-ingredient-calories")
    public ResponseEntity<FoodDTO> maxCalories(@RequestParam String dishName) {
        return ResponseEntity.ok(foodService.maxIngredientCalories(dishName));
    }

    @GetMapping("/dish-ingredients")
    public ResponseEntity<List<FoodDTO>> getMaxCalories(@RequestParam String dishName) {
        return ResponseEntity.ok(foodService.getIngredients(dishName));
    }

}
