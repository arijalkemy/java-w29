package com.example.calorias.repository;

import com.example.calorias.model.Ingredient;
import com.example.calorias.model.Plate;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PlateRepositoryImpl implements PlateRepository {

    private List<Plate> plates;

    private final IngredientsRepository ingredientRepository;

    @PostConstruct
    private void createPlates() {
        plates = List.of(
                Plate.builder().name("Pasta").build(),
                Plate.builder().name("Pizza").build(),
                Plate.builder().name("Hamburgesa").build(),
                Plate.builder().name("Sopa").build(),
                Plate.builder().name("Tacos").build()
        );
        plates.forEach(plate -> {
            List<Ingredient> ingredients = ingredientRepository.getRandomIngredients();
            plate.setIngredients(ingredients);
        });
    }

    @Override
    public Optional<Plate> getPlateByName(String name) {
        return plates.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst();
    }

}
