package com.meli.scaffolding.repositories;


import com.meli.scaffolding.dto.IngredientDTO;

public interface IngredientRepository {
  IngredientDTO findIngredientByName(String name);
}
