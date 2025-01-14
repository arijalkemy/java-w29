package com.thiagoschreck.local.calculadora_calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.thiagoschreck.local.calculadora_calorias.entity.Dish;
import com.thiagoschreck.local.calculadora_calorias.entity.Food;
import com.thiagoschreck.local.calculadora_calorias.utils.JsonFileMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {
    private final List<Food> food = JsonFileMapper.readFromJsonFile("food.json", new TypeReference<>(){});
    private final List<Dish> dishes = JsonFileMapper.readFromJsonFile("dishes.json", new TypeReference<>(){});

    @Override
    public Food getFoodByName(String name) {
        if (food == null) {
            return null;
        }
        return food.stream()
                .filter(food -> food.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Dish getDishByName(String name) {
        if (dishes == null) {
            return null;
        }
        return dishes.stream()
                .filter(dish -> dish.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
