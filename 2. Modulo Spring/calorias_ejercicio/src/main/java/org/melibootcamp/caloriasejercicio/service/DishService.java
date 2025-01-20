package org.melibootcamp.caloriasejercicio.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.melibootcamp.caloriasejercicio.dto.response.DishCaloriesDTO;
import org.melibootcamp.caloriasejercicio.dto.response.DishDTOResponse;
import org.melibootcamp.caloriasejercicio.dto.response.IngredientDTOResponse;
import org.melibootcamp.caloriasejercicio.entities.Dish;
import org.melibootcamp.caloriasejercicio.entities.Ingredient;
import org.melibootcamp.caloriasejercicio.repositories.DishRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepositoryImpl dishRepository;
    private final ObjectMapper objectMapper;

    public DishDTOResponse getTotalCalories(String name){
        Optional<Dish> dish = dishRepository.getDishByName(name);

        if(dish.isPresent()){
            Double gramesPerIngredient = dish.get().getWeigth() / dish.get().getIngredients().size();
            Double totalCalories = dish.get().getIngredients().stream().mapToDouble(d-> gramesPerIngredient * d.getCalories() / 100).sum();
            DishDTOResponse dishDTOResponse = dishToDto(dish.get(), gramesPerIngredient,totalCalories);
            return dishDTOResponse;
        }
        return null;
    }


    private DishDTOResponse dishToDto(Dish dish,Double gramesPerIngredient,Double totalCalories){
        List<IngredientDTOResponse> ingredientDTOResponses = dish.getIngredients().stream().map(i-> ingredientToDto(i,i.getTotalCalories(gramesPerIngredient))).toList();
        IngredientDTOResponse maxIngredientCalory = ingredientDTOResponses.stream().max(Comparator.comparing(IngredientDTOResponse::getTotalCalories)).get();
        return new DishDTOResponse(dish.getId(),dish.getName(),maxIngredientCalory,totalCalories,ingredientDTOResponses);
    }

    private IngredientDTOResponse ingredientToDto(Ingredient ingredient, Double totalCalories){
        return new IngredientDTOResponse(ingredient.getName(),totalCalories);
    }


}
