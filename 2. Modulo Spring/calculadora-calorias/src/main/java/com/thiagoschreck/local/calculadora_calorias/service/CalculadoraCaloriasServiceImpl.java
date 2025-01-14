package com.thiagoschreck.local.calculadora_calorias.service;

import com.thiagoschreck.local.calculadora_calorias.dto.FoodDTO;
import com.thiagoschreck.local.calculadora_calorias.dto.request.DishInfoRequestDTO;
import com.thiagoschreck.local.calculadora_calorias.dto.response.DishInfoResponseDTO;
import com.thiagoschreck.local.calculadora_calorias.entity.Dish;
import com.thiagoschreck.local.calculadora_calorias.entity.Food;
import com.thiagoschreck.local.calculadora_calorias.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class CalculadoraCaloriasServiceImpl implements ICalculadoraCaloriasService {
    private final IFoodRepository repository;

    @Autowired
    public CalculadoraCaloriasServiceImpl(IFoodRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DishInfoResponseDTO> getDishesInfo(List<DishInfoRequestDTO> dishesInfoRequest) {
        return dishesInfoRequest.stream()
                .map(this::getDishInfo)
                .filter(Objects::nonNull)
                .toList();
    }

    private DishInfoResponseDTO getDishInfo(DishInfoRequestDTO dishInfoRequest) {
        final Dish dish = repository.getDishByName(dishInfoRequest.name());
        if (dish == null) {
            return null;
        }

        final List<FoodDTO> ingredients = dish.ingredients().stream()
                .map(repository::getFoodByName)
                .filter(Objects::nonNull)
                .map(this::mapToDTO)
                .toList();
        final int totalCalories = ingredients.stream()
                .map(FoodDTO::calories)
                .map(calories -> calories * (dishInfoRequest.grams() > 0 ? dishInfoRequest.grams() : 1) / 100 )
                .reduce(Integer::sum)
                .orElse(0);
        final FoodDTO mostCaloricIngredient = ingredients.stream()
                .max(Comparator.comparingInt(FoodDTO::calories))
                .orElse(null);

        return new DishInfoResponseDTO(totalCalories, ingredients, mostCaloricIngredient);
    }

    private FoodDTO mapToDTO(Food food) {
        return new FoodDTO(food.name(), food.calories());
    }
}
