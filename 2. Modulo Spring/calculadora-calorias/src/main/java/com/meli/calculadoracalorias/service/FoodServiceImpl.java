package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.entity.Ingredient;
import com.meli.calculadoracalorias.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    public Optional<Integer> getCalories(Integer grams, String name) {
        return foodRepository.foodList.stream()
                .filter(food -> food.grams.equals(grams) && food.name.equals(name))
                .map(food -> food.calories)
                .findFirst();
    }

    public Optional<List<Ingredient>> getIngredients(Integer grams, String name) {
        return foodRepository.foodList.stream()
                .filter(food -> food.grams.equals(grams) && food.name.equals(name))
                .map(food -> food.ingredients)
                .findFirst();
    }
}
