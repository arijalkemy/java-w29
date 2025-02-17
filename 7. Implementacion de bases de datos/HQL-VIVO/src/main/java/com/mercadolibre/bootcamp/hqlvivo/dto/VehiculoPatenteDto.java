package com.mercadolibre.bootcamp.hqlvivo.dto;

public class VehiculoPatenteDto {

    String patente;

    public VehiculoPatenteDto(String patente) {
        this.patente = patente;
    }

    public VehiculoPatenteDto() {}

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

}
