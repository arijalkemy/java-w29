package com.meli.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculadoracalorias.entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class IngredientRepository {
    private List<Ingredient> ingredients;

    public IngredientRepository() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeReference = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/1. c. food.json");

        try {
            ingredients = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo JSON", e);
        }
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
