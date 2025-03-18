package com.bootcamp.caloriecalculator.service;

import com.bootcamp.caloriecalculator.dto.CaloriesDTO;
import com.bootcamp.caloriecalculator.dto.DishCompositionDTO;
import com.bootcamp.caloriecalculator.dto.IngredientDTO;
import com.bootcamp.caloriecalculator.model.Dish;
import com.bootcamp.caloriecalculator.model.Food;
import com.bootcamp.caloriecalculator.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    public CaloriesDTO getCalories(String name, int amount) {
        Dish dish = foodRepository
                .findByName(name)
                .orElseThrow(() -> new RuntimeException("Dish with name " + name + " not found"));

        Integer calories = dish
                .getIngredients()
                .stream()
                .map(Food::getCalories)
                .reduce(0, Integer::sum);

        return new CaloriesDTO(dish.getName(), amount, calories * amount);

    }

    public DishCompositionDTO getDishComposition(String dishName) {
        List<IngredientDTO> ingredients = foodRepository
                .findDishComposition(dishName)
                .stream()
                .map(i -> new IngredientDTO(i.getName(), i.getCalories()))
                .toList();

        if (ingredients.isEmpty()) {
            throw new RuntimeException("Dish with name " + dishName + " not found");
        }

        return new DishCompositionDTO(dishName, ingredients);
    }

    public IngredientDTO getHighestCalorie(String dishName) {
        return foodRepository
                .findByName(dishName)
                .stream()
                .map(Dish::getIngredients)
                .flatMap(List::stream)
                .max(Comparator.comparingInt(Food::getCalories))
                .map(this::toIngredientDTO)
                .orElseThrow(() -> new RuntimeException("Dish with name " + dishName + " not found"));
    }

    private IngredientDTO toIngredientDTO(Food food) {
        return new IngredientDTO(food.getName(), food.getCalories());
    }
}
