package com.example.calculadora_calorias.repository;


import com.example.calculadora_calorias.entity.Dish;
import com.example.calculadora_calorias.entity.Food;

public interface IFoodRepository {
    Food getFoodByName(String name);
    Dish getDishByName(String name);
}
