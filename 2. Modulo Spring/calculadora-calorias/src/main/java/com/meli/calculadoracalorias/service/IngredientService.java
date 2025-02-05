package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.entity.Ingredient;

import java.util.Optional;

public interface IngredientService {
    public Optional<Ingredient> majorCalories();
}
