package models;


public class Auto extends Vehiculo{

    private final static Integer N_RUEDAS = 4;
    private final static Double PESO_KG = 1000.0;

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_KG, N_RUEDAS);
    }
}
