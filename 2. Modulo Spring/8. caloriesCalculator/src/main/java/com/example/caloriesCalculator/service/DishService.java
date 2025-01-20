package com.example.caloriesCalculator.service;

import com.example.caloriesCalculator.entity.Dish;
import com.example.caloriesCalculator.entity.Ingredient;
import com.example.caloriesCalculator.repository.DishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class DishService implements IDishService {
    private final DishRepository dishRepository;

    @Override
    public String getAmountOfCalories(String name) {
        Dish dish = dishRepository.getAllDishes().stream()
                .filter(dish1 -> dish1.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        return "La cantidad de calorias es: " + Objects.requireNonNull(dish).getIngredients().stream()
                .mapToDouble(Ingredient::getCalories)
                .sum();
    }
}
