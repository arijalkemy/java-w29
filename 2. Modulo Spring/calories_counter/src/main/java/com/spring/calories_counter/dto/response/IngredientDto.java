package com.spring.calories_counter.dto.response;

public record IngredientDto(
        String name,
        Integer totalCalories
) {
}
