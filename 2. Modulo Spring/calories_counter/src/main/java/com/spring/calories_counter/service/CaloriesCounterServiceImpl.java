package com.spring.calories_counter.service;

import com.spring.calories_counter.dto.request.DishRequestDto;
import com.spring.calories_counter.dto.response.DishResponseDto;
import com.spring.calories_counter.dto.response.IngredientDto;
import com.spring.calories_counter.model.Dish;
import com.spring.calories_counter.model.Ingredient;
import com.spring.calories_counter.repository.CaloriesCounterRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CaloriesCounterServiceImpl implements CaloriesCounterService {
    @Autowired
    CaloriesCounterRepositoryImpl caloriesCounterRepository;

    @Override
    public List<DishResponseDto> findDishesDetail(List<DishRequestDto> receivedDishes) {
        return receivedDishes.stream()
                .map(this::findDishDetail)
                .toList();
    }

    private DishResponseDto findDishDetail(DishRequestDto receivedDish) {
        return mapDishToDto(caloriesCounterRepository.getDishNamed(receivedDish.name()));
    }

    private DishResponseDto mapDishToDto(Dish dish) {
        return new DishResponseDto(
                dish.name(),
                findTotalCalories(dish),
                mapIngredientsToDto(dish.ingredients()),
                findMostCaloricIngredient(dish)
        );
    }

    private Integer findTotalCalories(Dish dish) {
        return mapIngredientsToDto(dish.ingredients()).stream()
                .mapToInt(IngredientDto::totalCalories)
                .sum();
    }

    private List<IngredientDto> mapIngredientsToDto(List<Ingredient> ingredients) {
        return ingredients.stream().map(this::mapIngredientToDto).toList();
    }

    private IngredientDto mapIngredientToDto(Ingredient ingredient) {
        return new IngredientDto(ingredient.name(), ingredient.calories() * ingredient.units());
    }

    private IngredientDto findMostCaloricIngredient(Dish dish) {
        return mapIngredientsToDto(dish.ingredients())
                .stream()
                .max(Comparator.comparingInt(IngredientDto::totalCalories))
                .orElse(null);
    }
}
