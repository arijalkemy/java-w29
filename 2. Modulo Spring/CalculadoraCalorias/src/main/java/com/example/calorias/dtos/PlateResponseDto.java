package com.example.calorias.dtos;

import com.example.calorias.model.Ingredient;
import com.example.calorias.model.Plate;

import java.util.List;

public record PlateResponseDto (
        String name,
        Double weight,
        Integer totalCalories,
        Ingredient mostCaloricIngredient,
        List<Ingredient> ingredients
) {}