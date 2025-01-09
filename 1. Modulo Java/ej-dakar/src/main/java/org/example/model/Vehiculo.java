package org.example.model;

public abstract class Vehiculo {
    private final double velocidad;
    private final double aceleracion;
    private final double anguloDeGiro;
    private final String patente;
    private final double peso;
    private final int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double getPuntajeVelocidad() {
        return velocidad * (aceleracion / 2) / (anguloDeGiro * (peso - ruedas * 100));
    }

    public String getPatente() {
        return patente;
    }
}
