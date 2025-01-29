package com.calories.calories.repository;

import java.util.Optional;

import com.calories.calories.model.Ingredient;

public interface InterfaceIngredientRepository {
    Optional<Ingredient> findIngredientByName(String name);
}
