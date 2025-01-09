package DAKAR.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Auto implements Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private final double peso = 1000;
    private final int ruedas = 4;
}
