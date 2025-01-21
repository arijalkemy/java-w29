package com.mdaneri.caloriasp2vivo1.entity;

public class Food {

    private String name;
    private Integer calories;

    public Food() {}

    public Food(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
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
