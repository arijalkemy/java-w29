package com.mdaneri.caloriasp2vivo1.dtos;

import com.mdaneri.caloriasp2vivo1.entity.Food;

import java.util.List;


public class FoodDTO {

    private String name;
    private Integer calories;

    public FoodDTO() {}

    public FoodDTO(String name, Integer calories) {
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
