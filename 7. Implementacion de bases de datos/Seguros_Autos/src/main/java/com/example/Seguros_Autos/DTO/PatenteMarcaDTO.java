package com.example.Seguros_Autos.DTO;

public class PatenteMarcaDTO {

    private String patente;
    private String marca;

    // Constructor
    public PatenteMarcaDTO(String patente, String marca) {
        this.patente = patente;
        this.marca = marca;
    }

    // Getters y Setters
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
}

