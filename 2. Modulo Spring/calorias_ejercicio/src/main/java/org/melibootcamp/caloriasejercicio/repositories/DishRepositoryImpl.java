package org.melibootcamp.caloriasejercicio.repositories;

import org.melibootcamp.caloriasejercicio.entities.Dish;
import org.melibootcamp.caloriasejercicio.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DishRepositoryImpl implements IDishRepository{

    private List<Dish> dishes = new ArrayList<>();


    private IngredientsRepositoryImpl ingredientsRepository;

    public DishRepositoryImpl() throws IOException {
        ingredientsRepository = new IngredientsRepositoryImpl();
        loadDishes();
    }

    public void loadDishes(){
        ArrayList<Ingredient> ingredientsPizza = new ArrayList<>();
        Optional<Ingredient> ingredientQueso = ingredientsRepository.getByName("Queso blanco desnatado");
        Optional<Ingredient> ingredientPina = ingredientsRepository.getByName("Piña colada");
        Optional<Ingredient> ingredientPisco = ingredientsRepository.getByName("Pisco");

        ingredientsPizza.add(ingredientPina.get());
        ingredientsPizza.add(ingredientPisco.get());
        ingredientsPizza.add(ingredientQueso.get());
        dishes.add(new Dish(1,"Pizza",500.0,ingredientsPizza));
    }

    @Override
    public Optional<Dish> getDishByName(String name) {
        return dishes.stream().filter(d-> d.getName().equals(name)).findFirst();
    }
}
