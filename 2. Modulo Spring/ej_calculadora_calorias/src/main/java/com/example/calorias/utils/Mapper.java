package com.example.calorias.utils;

import com.example.calorias.dtos.PlateResponseDto;
import com.example.calorias.model.Ingredient;
import com.example.calorias.model.Plate;

public class Mapper {
    public static PlateResponseDto createPlateResponse(Plate plate, Integer totalCalories,
                                                        Ingredient mostCaloricIngredient) {
        return new PlateResponseDto(
                plate.getName(), plate.getWeight(), totalCalories, mostCaloricIngredient, plate.getIngredients()
        );
    }
}
