package com.example.ejercicio_contadorcalorias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteDTO_Out {
    private String name;
    private Integer calories;
}