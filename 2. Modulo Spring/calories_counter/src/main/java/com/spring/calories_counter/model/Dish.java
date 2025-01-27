package com.spring.calories_counter.model;

import java.util.List;

public record Dish (
        String name,
        List<Ingredient> ingredients
) {}
