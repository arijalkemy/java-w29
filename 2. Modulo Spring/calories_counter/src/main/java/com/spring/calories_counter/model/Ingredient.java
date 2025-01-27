package com.spring.calories_counter.model;

public record Ingredient(
        String name,
        Integer calories,
        Integer units
) {
}
