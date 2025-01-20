package org.melibootcamp.caloriasejercicio.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.melibootcamp.caloriasejercicio.entities.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientsRepositoryImpl implements IIngredientsRepository{

    private List<Ingredient> ingredients = new ArrayList<>();

    public IngredientsRepositoryImpl() throws IOException {
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingredient> ingredientsList;

        file= ResourceUtils.getFile("src/main/resources/food.json");
        ingredientsList = objectMapper.readValue(file,new TypeReference<>(){});

        this.ingredients = ingredientsList;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return List.of();
    }

    @Override
    public Optional<Ingredient> getByName(String name) {
        return ingredients.stream().filter(i->i.getName().equals(name)).findFirst();
    }
}
