package com.bootcamp.ej_practicos_p2.repository;

import com.bootcamp.ej_practicos_p2.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FileIngredientRepository implements IIngredientRepository{
    private List<Ingredient> ingredients = new ArrayList<>();

    public FileIngredientRepository() {
        loadData();
    }

    public void loadData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream inJson = Ingredient.class.getResourceAsStream("/static/food.json");
            TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};

            ingredients = mapper.readValue(inJson, typeRef);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            // e.printStackTrace();
        }
    }

    @Override
    public List<Ingredient> filterIngredientsByName(List<String> names) {
        return ingredients.stream().filter(i -> names.contains(i.getName())).collect(Collectors.toList());
    }
}
