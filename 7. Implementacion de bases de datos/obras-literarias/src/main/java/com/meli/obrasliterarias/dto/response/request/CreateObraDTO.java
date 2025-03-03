package com.meli.obrasliterarias.dto.response.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateObraDTO {
    private String nombre;
    private String autor;
    @JsonProperty("cantidad_paginas")
    private int cantidadPaginas;
    private String editorial;
    @JsonProperty("anio_publicacion")
    private int anioPublicacion;
}
