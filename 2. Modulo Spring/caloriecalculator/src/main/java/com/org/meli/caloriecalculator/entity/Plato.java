package com.org.meli.caloriecalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Plato {
    String nombre;
    List<Ingrediente> ingredientes;
    Integer calorias;
}
