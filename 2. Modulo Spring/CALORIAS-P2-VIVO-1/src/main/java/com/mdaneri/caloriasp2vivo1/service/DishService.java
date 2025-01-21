package com.mdaneri.caloriasp2vivo1.service;

import com.mdaneri.caloriasp2vivo1.dtos.DishDTO;
import com.mdaneri.caloriasp2vivo1.dtos.FoodDTO;
import com.mdaneri.caloriasp2vivo1.entity.Dish;
import com.mdaneri.caloriasp2vivo1.entity.Food;
import com.mdaneri.caloriasp2vivo1.exception.FoodNotFoundException;
import com.mdaneri.caloriasp2vivo1.repository.IFileDishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService implements IDishService {

    private IFileDishRepository fileDishRepository;

    public DishService(IFileDishRepository fileDishRepository) {
        this.fileDishRepository = fileDishRepository;
    }

    @Override
    public Integer getCalories(String foodName) {
        Optional<Dish> optionalDish = fileDishRepository.findByName(foodName);

        if (optionalDish.isEmpty())
            throw new FoodNotFoundException("Food not found!");
        return optionalDish.get().getIngredients().stream().mapToInt(Food::getCalories).sum();
    }

    public List<FoodDTO> getIngredients(String dishName) {
        Optional<Dish> optionalDish = fileDishRepository.findByName(dishName);

        if (optionalDish.isEmpty())
            throw new FoodNotFoundException("Food not found!");

        return optionalDish.get().getIngredients().stream().map(f -> new FoodDTO(f.getName(), f.getCalories())).toList();
    }

    @Override
    public FoodDTO maxIngredientCalories(String dishName) {
        Optional<Dish> optionalDish = fileDishRepository.findByName(dishName);

        if (optionalDish.isEmpty())
            throw new FoodNotFoundException("Food not found!");

        Food food = optionalDish.get().getIngredients().stream().max((f1, f2) -> f1.getCalories().compareTo(f2.getCalories())).orElseThrow();
        return new FoodDTO(food.getName(), food.getCalories());
    }

}
