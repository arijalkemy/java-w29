package com.calories.calories.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DishRequestDto {
    private String name;
    private List<IngredientRequestDto> ingredients;
}
