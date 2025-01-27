package com.spring.calories_counter.repository;

import com.spring.calories_counter.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CaloriesCounterRepositoryImpl implements CaloriesCounterRepository{
    private List<Dish> dishes = new ArrayList<>(); // TODO: I have to add some dishes

    @Override
    public Dish getDishNamed(String name) {
        return dishes.stream()
                .filter(dish -> dish.name().equals(name))
                .findFirst()
                .orElse(null);
    }
}
