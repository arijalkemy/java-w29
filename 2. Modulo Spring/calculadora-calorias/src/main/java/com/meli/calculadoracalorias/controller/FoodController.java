package com.meli.calculadoracalorias.controller;

import com.meli.calculadoracalorias.entity.Ingredient;
import com.meli.calculadoracalorias.service.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {
    @Autowired
    FoodServiceImpl foodServiceImpl;
    @GetMapping("/food/getCalories/{nombre}/{gramos}")
    public Optional<Integer> getCalories(@PathVariable("nombre") String nombre, @PathVariable("gramos") Integer gramos) {
        return foodServiceImpl.getCalories(gramos, nombre);
    }

    @GetMapping("/food/getIngredients/{nombre}/{gramos}")
    public Optional<List<Ingredient>> getIngredients(@PathVariable("nombre") String nombre, @PathVariable("gramos") Integer gramos) {
        return foodServiceImpl.getIngredients(gramos, nombre);
    }

}
