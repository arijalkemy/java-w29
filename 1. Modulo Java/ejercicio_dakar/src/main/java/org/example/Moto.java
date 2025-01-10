package org.example;

public class Moto extends Vehiculo{

    private float PESO = 300f;
    private int CANTIDAD_RUEDAS = 2;

    public Moto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300f, 2);
    }
}


