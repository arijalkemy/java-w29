package com.bootcamp.caloriecalculator.dto;

import java.util.List;

public record DishCompositionDTO(
        String name,
        List<IngredientDTO> ingredients
) {
}
