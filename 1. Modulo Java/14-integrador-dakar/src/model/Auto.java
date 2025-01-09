package model;

public class Auto extends Vehiculo{
    private static final Integer RUEDAS = 4;
    private static final Double PESO = 1000.0;
    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }
}
