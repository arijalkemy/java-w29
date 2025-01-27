package com.spring.calories_counter.dto.response;

import java.util.List;

public record DishResponseDto(
        String name,
        Integer totalCalories,
        List<IngredientDto> ingredients,
        IngredientDto mostCaloricIngredient
) {
}
