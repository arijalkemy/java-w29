package com.example.Seguros_Autos.DTO;

public class VehiculoSiniestroTotalLossDTO {
    private String patente;
    private String marca;
    private String modelo;
    private Double totalLoss;

    public VehiculoSiniestroTotalLossDTO(String patente, String marca, String modelo, Double totalLoss) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.totalLoss = totalLoss;
    }

    // Getters and Setters
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

    public Double getTotalLoss() {
        return totalLoss;
    }

    public void setTotalLoss(Double totalLoss) {
        this.totalLoss = totalLoss;
    }
}

