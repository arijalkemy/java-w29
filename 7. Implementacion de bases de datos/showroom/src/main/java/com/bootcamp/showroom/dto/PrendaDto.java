package com.bootcamp.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PrendaDto {
    private Long codigo;
    private String nombre;
    private String tipo;
    private String talla;
    private String color;
    private String marca;
    private Integer cantidad;
    @JsonProperty("precio_venta")
    private Double precioVenta;
}
