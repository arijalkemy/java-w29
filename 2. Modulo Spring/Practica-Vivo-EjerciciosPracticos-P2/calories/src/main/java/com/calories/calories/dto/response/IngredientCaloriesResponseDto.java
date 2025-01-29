package com.calories.calories.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class IngredientCaloriesResponseDto {
    private String name;
    private Integer calories;
}
