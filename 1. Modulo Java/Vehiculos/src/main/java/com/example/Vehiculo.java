package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehiculo {
    private String marca;

    private String modelo;

    private double costo;
}

