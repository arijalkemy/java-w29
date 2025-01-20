package com.example.caloriesCalculator.repository;

import com.example.caloriesCalculator.entity.Dish;
import com.example.caloriesCalculator.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class DishRepository implements IDishRepository {
    private List<Ingredient> ingredients;
    private List<Dish> dishes;

    public DishRepository() {
        readJsonFile();
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishes;
    }

    @Override
    public void saveDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    /**
     * Read json file and put into list of character
     */
    private void readJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("food.json");
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            ingredients = objectMapper.readValue(inputStream, new TypeReference<List<Ingredient>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
