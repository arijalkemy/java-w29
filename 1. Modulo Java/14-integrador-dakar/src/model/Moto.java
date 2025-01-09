package model;

public class Moto extends Vehiculo{
    private static final Integer RUEDAS = 2;
    private static final Double PESO = 300.0;
    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }
}
