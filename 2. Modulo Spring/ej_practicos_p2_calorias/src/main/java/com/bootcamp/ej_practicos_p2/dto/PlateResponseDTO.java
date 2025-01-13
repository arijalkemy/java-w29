package com.bootcamp.ej_practicos_p2.dto;

import com.bootcamp.ej_practicos_p2.model.Ingredient;
import com.bootcamp.ej_practicos_p2.model.Plate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlateResponseDTO {
    private String name;
    private Double weight;
    private Integer totalCalories;
    private Ingredient mostCaloricIngredient;
    private List<Ingredient> ingredients;

    public PlateResponseDTO(Plate plate) {
        this.name = plate.getName();
        this.weight = plate.getWeight();
        this.ingredients = plate.getIngredients();
    }
}
