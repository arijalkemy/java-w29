package com.mdaneri.caloriasp2vivo1.dtos;

import com.mdaneri.caloriasp2vivo1.entity.Food;

import java.util.List;

public class DishDTO {

    private final String name;
    private final List<String> ingredients;

    public DishDTO(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
