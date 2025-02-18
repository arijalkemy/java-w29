package com.meli.ejerciciohql.model.DTO;

public class VehicleDtoByPatenteAnio {
    private String patente;
    private Integer fabricacionAnio;

    public VehicleDtoByPatenteAnio(String patente, Integer fabricacionAnio) {
        this.patente = patente;
        this.fabricacionAnio = fabricacionAnio;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getFabricacionAnio() {
        return fabricacionAnio;
    }

    public void setFabricacionAnio(Integer fabricacionAnio) {
        this.fabricacionAnio = fabricacionAnio;
    }

    @Override
    public String toString() {
        return "VehicleDtoByPatenteAnio{" +
                "patente='" + patente + '\'' +
                ", fabricacionAnio=" + fabricacionAnio +
                '}';
    }
}
