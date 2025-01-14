package com.thiagoschreck.local.calculadora_calorias.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thiagoschreck.local.calculadora_calorias.dto.FoodDTO;

import java.util.List;

public record DishInfoResponseDTO(
        @JsonProperty("total_calories")
        int totalCalories,
        List<FoodDTO> ingredients,
        @JsonProperty("most_caloric_ingredient")
        FoodDTO mostCaloricIngredient) {
}
