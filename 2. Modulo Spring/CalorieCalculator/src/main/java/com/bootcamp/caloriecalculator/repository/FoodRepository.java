package com.bootcamp.caloriecalculator.repository;

import com.bootcamp.caloriecalculator.dto.DishCompositionDTO;
import com.bootcamp.caloriecalculator.model.Dish;
import com.bootcamp.caloriecalculator.model.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class FoodRepository {
    List<Food> foods;
    List<Dish> dishes;
    ResourceLoader resourceLoader;

    public FoodRepository(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.foods = loadFood();
        this.dishes = loadDishes();
    }

    private List<Food> loadFood() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Resource resource = resourceLoader.getResource("classpath:food.json");
            if (!resource.exists()) {
                throw new FileNotFoundException("Couldn't load food.json");
            }
            return objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private List<Dish> loadDishes() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Resource resource = resourceLoader.getResource("classpath:dish.json");

            if (!resource.exists()) {
                throw new FileNotFoundException("Couldn't load dish.json");
            }

            List<Map<String, Object>> dishList = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});

            return dishList
                    .stream()
                    .map(dishData -> {
                        Dish dish = new Dish();
                        dish.setName((String) dishData.get("nombre"));
                        List<String> ingredientNames = (List<String>) dishData.get("ingredientes");

                        List<Food> dishIngredients = ingredientNames
                                .stream()
                                .map(this::findFoodByName)
                                .filter(Optional::isPresent)
                                .map(Optional::get)
                                .toList();

                        dish.setIngredients(dishIngredients);
                        return dish;
                    })
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Optional<Food> findFoodByName(String name) {
        return foods
                .stream()
                .filter(f -> f.getName().equalsIgnoreCase(name))
                .findFirst();
    }


    public Optional<Dish> findByName(String name) {
        return dishes
                .stream()
                .filter(f -> f.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Food> findDishComposition(String dishName) {
        return dishes
                .stream()
                .filter(d -> d.getName().equalsIgnoreCase(dishName))
                .findFirst()
                .map(Dish::getIngredients)
                .orElse(List.of());
    }
}
