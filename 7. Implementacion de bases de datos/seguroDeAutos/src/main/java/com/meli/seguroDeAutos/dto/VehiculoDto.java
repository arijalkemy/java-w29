package com.meli.seguroDeAutos.dto;

import lombok.Data;

@Data
public class VehiculoDto {
    private Integer id;
    private Long patente;
    private String modelo;
    private Integer yearDeFabricacion;
    private Integer cantidadDeRuedas;
}
