package com.mdaneri.caloriasp2vivo1.service;


import com.mdaneri.caloriasp2vivo1.dtos.DishDTO;
import com.mdaneri.caloriasp2vivo1.dtos.FoodDTO;
import com.mdaneri.caloriasp2vivo1.entity.Dish;
import com.mdaneri.caloriasp2vivo1.entity.Food;
import com.mdaneri.caloriasp2vivo1.exception.FoodNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IDishService {

    Integer getCalories(String foodName);
    List<FoodDTO> getIngredients(String dishName);
    FoodDTO maxIngredientCalories(String dishName);

}
