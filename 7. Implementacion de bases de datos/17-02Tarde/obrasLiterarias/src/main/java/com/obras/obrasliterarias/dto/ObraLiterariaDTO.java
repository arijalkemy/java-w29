package com.obras.obrasliterarias.dto;

import lombok.Data;

@Data
public class ObraLiterariaDTO {
    private Long id;
    private String nombre;
    private String autor;
    private int cantidad_de_paginas;
    private String editorial;
    private int anio_primer_publicacion;
}
