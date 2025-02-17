package com.api.food.dto;

import com.api.food.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@Data
public class CalculoResponseDTO implements Serializable {

    private Integer totalCalorias;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingredienteMasCalorico;

}
