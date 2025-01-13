package com.bootcamp.ej_practicos_p2.repository;

import com.bootcamp.ej_practicos_p2.model.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    List<Ingredient> filterIngredientsByName(List<String> names);
}
