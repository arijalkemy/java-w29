package com.meli.calculadoracalorias.repository;

import com.meli.calculadoracalorias.entity.Food;
import com.meli.calculadoracalorias.entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FoodRepository {
    public List<Food> foodList;
    private IngredientRepository ingredientRepository;

    public FoodRepository() {
        this.ingredientRepository = new IngredientRepository();
        this.foodList = new ArrayList<>();

        List<Ingredient> ingredients = ingredientRepository.getIngredients();

        // Crear comidas usando los ingredientes del repositorio
        foodList.add(new Food("Ensalada Variada", findIngredients(ingredients, List.of("Aceitunas negras", "Lechuga", "Tomates")), 250));
        foodList.add(new Food("Plato Mediterráneo", findIngredients(ingredients, List.of("Ajos", "Alcachofas", "Pepino")), 300));
        foodList.add(new Food("Sopa Campestre", findIngredients(ingredients, List.of("Brócoli", "Cebolla", "Zanahoria")), 350));
        foodList.add(new Food("Asado Vegetal", findIngredients(ingredients, List.of("Calabaza", "Acelgas", "Pimientos")), 400));
        foodList.add(new Food("Mix de Hortalizas", findIngredients(ingredients, List.of("Apio", "Berenjena", "Espinaca")), 270));
        foodList.add(new Food("Verde Fresco", findIngredients(ingredients, List.of("Calabacín", "Berros", "Espárragos")), 220));
        foodList.add(new Food("Grill de Hojas", findIngredients(ingredients, List.of("Escarola", "Col", "Porotos verdes")), 180));
        foodList.add(new Food("Delicia de Campo", findIngredients(ingredients, List.of("Rúcula", "Hinojo", "Rábanos")), 200));
        foodList.add(new Food("Colorido Gourmet", findIngredients(ingredients, List.of("Remolacha", "Perejil", "Habas tiernas")), 340));
        foodList.add(new Food("Picada Natural", findIngredients(ingredients, List.of("Endibia", "Cebolla tierna", "Champiñón y otras setas")), 285));
    }

    private List<Ingredient> findIngredients(List<Ingredient> allIngredients, List<String> names) {
        return allIngredients.stream()
                .filter(i -> names.contains(i.getName()))
                .collect(Collectors.toList());
    }
}