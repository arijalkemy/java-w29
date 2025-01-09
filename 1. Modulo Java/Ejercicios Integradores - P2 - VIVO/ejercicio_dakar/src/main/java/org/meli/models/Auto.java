package org.meli.models;

public class Auto extends Vehiculo{
    private static final Double PESO = 1000.0;
    private static final Integer RUEDAS = 4;

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }
}
