package org.example;

import lombok.Data;

@Data
public class Auto extends Vehiculo {

    private static final Double PESO = 1000.0;

    private static final Integer RUEDAS = 4;

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }

}