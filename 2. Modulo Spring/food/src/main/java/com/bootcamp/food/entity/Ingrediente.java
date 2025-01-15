package com.bootcamp.food.entity;

public class Ingrediente {
    private String name;
    private int calories;
    public Ingrediente() {}
    public Ingrediente(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Ingrediente{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
}
