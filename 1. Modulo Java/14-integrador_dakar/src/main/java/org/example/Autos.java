package org.example;

public class Autos extends Vehiculo{
    private  static Double peso =1000.0;
    private static Integer ruedas=4;
    public Autos(Integer velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, peso, ruedas);
    }
}
