package com.bootcamp.food.dto;

import com.bootcamp.food.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CalculoResponseDTO {
    private Integer totalCalorias;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingredienteMasCalorico;
}
