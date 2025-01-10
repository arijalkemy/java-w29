package models;


import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public abstract class Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private Double pesoEnKg;
    private Integer ruedas;

    public Double calcularRendimiento() {
        return (velocidad * 0.5 * aceleracion) / (anguloDeGiro * (pesoEnKg - ruedas * 100));
    }

}
