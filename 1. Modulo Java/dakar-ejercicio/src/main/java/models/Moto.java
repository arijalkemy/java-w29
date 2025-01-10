package models;

public class Moto extends Vehiculo{

    private final static Integer RUEDAS = 2;
    private final static Double PESO_KG = 300.0;

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_KG, RUEDAS);
    }
}
