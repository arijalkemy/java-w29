package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Vehiculo {

    private Double velocidad;

    private Double aceleracion;

    private Double anguloDeGiro;

    private String patente;

    private Double peso;

    private Integer ruedas;

    public Double calcularPuntaje() {
        return velocidad * 0.5 * aceleracion / (anguloDeGiro * (peso - ruedas * 100));
    }

}
