package com.bootcamp.ej_practicos_p2.repository;

import com.bootcamp.ej_practicos_p2.model.Ingredient;
import com.bootcamp.ej_practicos_p2.model.Plate;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlateRepository {

    private List<Plate> plates;
    private FileIngredientRepository ingredientRepository;

    @Autowired
    public PlateRepository(FileIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Plate getPlateByName(String name) {
        return plates.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    @PostConstruct
    private void createPlates() {
        plates = List.of(
                Plate.builder().name("Pasta").build(),
                Plate.builder().name("Pizza").build(),
                Plate.builder().name("Hamburgesa").build(),
                Plate.builder().name("Sopa").build(),
                Plate.builder().name("Tacos").build()
        );
        for (Plate plate : plates) {
            List<Ingredient> ingredients = ingredientRepository.getRandomIngredients();
            plate.setIngredients(ingredients);
        }
    }

}
