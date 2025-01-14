package com.bootcamp.CalculadoraCalorias.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingrediente {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("calories")
    private Integer calorias;
}
