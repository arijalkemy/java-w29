package com.example.calorias.repository;

import com.example.calorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientsRepositoryImpl implements IngredientsRepository {

    private List<Ingredient> ingredients = new ArrayList<>();

    public IngredientsRepositoryImpl() {
        loadData();
    }

    public void loadData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inJson = Ingredient.class.getResourceAsStream("/food.json");
            TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};

            ingredients = mapper.readValue(inJson, typeRef);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Ingredient> getRandomIngredients() {
        return ingredients.stream().filter(i -> Math.random() < 0.01).collect(Collectors.toList());
    }
}
