package com.meli.calculadoracalorias.entity;

public class Ingredient {
    public String name;
    public Integer calories;

    public Ingredient(Integer calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
