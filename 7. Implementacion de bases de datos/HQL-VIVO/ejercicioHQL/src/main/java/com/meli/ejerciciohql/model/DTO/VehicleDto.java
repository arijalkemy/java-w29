package com.meli.ejerciciohql.model.DTO;

import jakarta.persistence.Column;

public class VehicleDto {
    private String patente;
    private String marca;
    private String modelo;
    private Integer fabricacionAnio;
    private Integer cantidadRuedas;

    public VehicleDto(String patente, String marca, String modelo, Integer fabricacionAnio, Integer cantidadRuedas) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.fabricacionAnio = fabricacionAnio;
        this.cantidadRuedas = cantidadRuedas;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getFabricacionAnio() {
        return fabricacionAnio;
    }

    public void setFabricacionAnio(Integer fabricacionAnio) {
        this.fabricacionAnio = fabricacionAnio;
    }

    public Integer getCantidadRuedas() {
        return cantidadRuedas;
    }

    public void setCantidadRuedas(Integer cantidadRuedas) {
        this.cantidadRuedas = cantidadRuedas;
    }

    @Override
    public String toString() {
        return "VehicleDto{" +
                "patente='" + patente + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fabricacionAnio=" + fabricacionAnio +
                ", cantidadRuedas=" + cantidadRuedas +
                '}';
    }
}
