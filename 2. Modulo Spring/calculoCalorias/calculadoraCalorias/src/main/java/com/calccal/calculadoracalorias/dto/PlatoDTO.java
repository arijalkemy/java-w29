package com.calccal.calculadoracalorias.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlatoDTO {
    private String name;private
    List<IngredienteDTO> ingredientes;
    private int calories;

    public PlatoDTO(List<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getCalories() {
        int totalCalories = 0;
        for (IngredienteDTO ingrediente : ingredientes) {
            totalCalories += ingrediente.getCalories();
        }
        return totalCalories;
    }
}