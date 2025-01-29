package com.calories.calories.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.calories.calories.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class IngredientRepositoryImpl implements InterfaceIngredientRepository {

    List<Ingredient> ingredients = new ArrayList<>();

    public IngredientRepositoryImpl() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inputStream = IngredientRepositoryImpl.class.getClassLoader()
                    .getResourceAsStream("1. c. food.json");
            this.ingredients = mapper.readValue(inputStream, new TypeReference<List<Ingredient>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Ingredient> findIngredientByName(String name) {
        return Optional.ofNullable(
                this.ingredients.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst()
                        .orElse(null));
    }

}
