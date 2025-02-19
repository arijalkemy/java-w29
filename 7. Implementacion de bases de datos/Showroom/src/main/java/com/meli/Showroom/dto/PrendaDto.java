package com.meli.Showroom.dto;

import lombok.Data;

@Data
public class PrendaDto {
    private Integer id;
    private Integer codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talla;
    private Integer cantidad;
    private Double precioVenta;
}
