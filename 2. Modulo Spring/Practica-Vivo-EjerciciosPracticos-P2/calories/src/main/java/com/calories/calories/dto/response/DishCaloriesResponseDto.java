package com.calories.calories.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DishCaloriesResponseDto {
    private String name;
    private Integer total_calories;
    private IngredientCaloriesResponseDto ingredient_max_calories;
    private List<IngredientCaloriesResponseDto> ingredients;
}
