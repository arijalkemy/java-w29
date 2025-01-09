package com.example.model;

import lombok.Data;

@Data
public class Moto extends Vehiculo {

    private static final Double PESO = 300.0;

    private static final Integer RUEDAS = 2;

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }

}
