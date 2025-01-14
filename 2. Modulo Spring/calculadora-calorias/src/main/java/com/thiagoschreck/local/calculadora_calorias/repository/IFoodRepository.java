package com.thiagoschreck.local.calculadora_calorias.repository;

import com.thiagoschreck.local.calculadora_calorias.entity.Dish;
import com.thiagoschreck.local.calculadora_calorias.entity.Food;

public interface IFoodRepository {
    Food getFoodByName(String name);
    Dish getDishByName(String name);
}
