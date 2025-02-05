package com.meli.calculadoracalorias.controller;

import com.meli.calculadoracalorias.entity.Ingredient;
import com.meli.calculadoracalorias.service.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class IngredientController {
    @Autowired
    private IngredientServiceImpl ingredientServiceImpl;

    @GetMapping("/ingredient/majorCalories")
    public Optional<Ingredient> getAllMajorCalories() {
        return ingredientServiceImpl.majorCalories();
    }
}
