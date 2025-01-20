package org.melibootcamp.caloriasejercicio.repositories;

import org.melibootcamp.caloriasejercicio.entities.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IIngredientsRepository {

    List<Ingredient> getAllIngredients();
    Optional<Ingredient> getByName(String name);

}
