package com.example.caloriesCalculator.repository;

import com.example.caloriesCalculator.entity.Dish;

import java.util.List;

public interface IDishRepository {
    List<Dish> getAllDishes();
    void saveDishes(List<Dish> dishes);
}
