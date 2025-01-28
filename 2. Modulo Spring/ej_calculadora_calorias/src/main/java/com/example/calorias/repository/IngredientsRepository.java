package com.example.calorias.repository;

import com.example.calorias.model.Ingredient;

import java.util.List;

public interface IngredientsRepository {
    List<Ingredient> findRandomIngredients();
}
