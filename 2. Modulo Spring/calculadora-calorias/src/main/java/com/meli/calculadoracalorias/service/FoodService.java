package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    Optional<Integer> getCalories(Integer grams, String name);
    Optional<List<Ingredient>> getIngredients(Integer grams, String name);
}
