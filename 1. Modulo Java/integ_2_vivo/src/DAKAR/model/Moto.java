package DAKAR.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Moto implements Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private final double peso = 300;
    private final int ruedas = 2;
}