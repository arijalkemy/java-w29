package com.mercadolibre.bootcamp.hqlvivo.dto;

public class VehiculoPatenteModeloMarcaDto extends VehiculoPatenteDto {

    private String modelo;
    private String marca;

    public VehiculoPatenteModeloMarcaDto(String patente, String modelo, String marca) {
        super(patente);
        this.modelo = modelo;
        this.marca = marca;
    }

    public VehiculoPatenteModeloMarcaDto() {}

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}


