package com.meli.ejerciciohql.model.DTO;

public class VehicleDtoByPatente {
    private String patente;

    public VehicleDtoByPatente(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "VehicleDtoByPatente{" +
                "patente='" + patente + '\'' +
                '}';
    }
}
