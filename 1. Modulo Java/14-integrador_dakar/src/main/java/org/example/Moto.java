package org.example;

public class Moto extends Vehiculo {
    private  static Double peso =300.0;
    private static Integer ruedas=2;


    public Moto(Integer velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro,patente, peso, ruedas);
    }
}
