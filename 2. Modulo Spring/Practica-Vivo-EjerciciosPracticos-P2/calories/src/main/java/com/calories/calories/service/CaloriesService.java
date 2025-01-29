package com.calories.calories.service;

import java.util.concurrent.atomic.AtomicReference;

import org.springframework.stereotype.Service;

import com.calories.calories.dto.request.DishRequestDto;
import com.calories.calories.dto.response.DishCaloriesResponseDto;
import com.calories.calories.dto.response.IngredientCaloriesResponseDto;
import com.calories.calories.exceptions.NotFoundException;
import com.calories.calories.model.Ingredient;
import com.calories.calories.repository.InterfaceIngredientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CaloriesService {

    private final InterfaceIngredientRepository ingredientRepository;

    public DishCaloriesResponseDto calculateCalories(DishRequestDto dish) {

        AtomicReference<Integer> totalCalories = new AtomicReference<>(0);
        AtomicReference<IngredientCaloriesResponseDto> max_calories_ingredient = new AtomicReference<>();

        return DishCaloriesResponseDto.builder().name(dish.getName())
                .ingredients(dish.getIngredients().stream().map(ingredient -> {
                    Ingredient ingredientFound = this.ingredientRepository.findIngredientByName(ingredient.getName())
                            .orElseThrow(() -> new NotFoundException("Ingrediente no encontrado"));

                    totalCalories.updateAndGet(v -> v + ingredientFound.getCalories());
                    if (max_calories_ingredient.get() == null) {
                        max_calories_ingredient.set(IngredientCaloriesResponseDto.builder().name(
                                ingredientFound.getName()).calories(
                                        ingredientFound.getCalories())
                                .build());
                    } else if (max_calories_ingredient.get().getCalories() < ingredientFound.getCalories()) {
                        max_calories_ingredient.set(IngredientCaloriesResponseDto.builder().name(
                                ingredientFound.getName()).calories(
                                        ingredientFound.getCalories())
                                .build());
                    }

                    return IngredientCaloriesResponseDto.builder().name(
                            ingredientFound.getName()).calories(
                                    ingredientFound.getCalories())
                            .build();
                }).toList()).total_calories(totalCalories.get()).ingredient_max_calories(max_calories_ingredient.get())
                .build();

    }

}
