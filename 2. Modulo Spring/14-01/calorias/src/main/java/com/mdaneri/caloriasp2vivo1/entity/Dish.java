package com.mdaneri.caloriasp2vivo1.entity;

import java.util.List;

public class Dish {

    private String name;
    private List<Food> ingredients;

    public Dish(String name, List<Food> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public List<Food> getIngredients() {
        return ingredients;
    }
}
