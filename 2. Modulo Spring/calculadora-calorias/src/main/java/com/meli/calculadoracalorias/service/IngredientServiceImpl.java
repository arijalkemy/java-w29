package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.entity.Ingredient;
import com.meli.calculadoracalorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public Optional<Ingredient> majorCalories() {
        return ingredientRepository.getIngredients().stream().max(Comparator.comparingInt(Ingredient::getCalories));
    }
}
