package com.mdaneri;

import java.util.Objects;

public abstract class Vehiculo {

    private Integer velocidad;
    private Integer aceleracion;
    private Double angulo;
    private String patente;
    private Double peso;
    private Integer ruedas;

    public Vehiculo(Integer velocidad, Integer aceleracion, Double angulo, String patente, Double peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.angulo = angulo;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public Integer getAceleracion() {
        return aceleracion;
    }

    public Double getAngulo() {
        return angulo;
    }

    public String getPatente() {
        return patente;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(velocidad, vehiculo.velocidad) && Objects.equals(aceleracion, vehiculo.aceleracion) && Objects.equals(angulo, vehiculo.angulo) && Objects.equals(patente, vehiculo.patente) && Objects.equals(peso, vehiculo.peso) && Objects.equals(ruedas, vehiculo.ruedas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(velocidad, aceleracion, angulo, patente, peso, ruedas);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", angulo=" + angulo +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
