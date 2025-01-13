package com.example.demo.integradores.dakar;

public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public double getPeso() {
        return peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public double getPerformance(){
        return this.velocidad * 0.5 * this.aceleracion / (this.anguloDeGiro * (this.peso - this.ruedas *100) );
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
}
