package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingrediente {
    private String nombre;
    private double peso;
    private double calorias;
}
