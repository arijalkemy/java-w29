package com.spring.calories_counter.repository;

import com.spring.calories_counter.model.Dish;

public interface CaloriesCounterRepository {
    Dish getDishNamed(String name);
}
