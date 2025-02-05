package com.meli.calculadoracalorias.entity;

import java.util.List;

public class Food {
    public String name;
    public List<Ingredient> ingredients;
    public Integer calories;
    public Integer grams;


    public Food(String name, List<Ingredient> ingredients, Integer grams) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = ingredients.stream().mapToInt(Ingredient::getCalories).sum();
        this.grams = grams;
    }
}
