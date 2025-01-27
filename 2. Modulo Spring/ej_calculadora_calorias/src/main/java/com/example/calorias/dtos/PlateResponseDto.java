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
) {
    public static PlateResponseDto createPlateResponse (Plate plate, Integer totalCalories,
                                                        Ingredient mostCaloricIngredient) {
        return new PlateResponseDto(
                plate.getName(), plate.getWeight(), totalCalories, mostCaloricIngredient, plate.getIngredients()
        );
    }
}
