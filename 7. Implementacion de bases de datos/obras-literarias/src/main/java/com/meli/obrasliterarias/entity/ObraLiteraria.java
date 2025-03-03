package com.meli.obrasliterarias.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obras")
public class ObraLiteraria {
    @Id
    private Long id;
    private String nombre;
    private String autor;
    @JsonProperty("cantidad_paginas")
    private int cantidadPaginas;
    private String editorial;
    @JsonProperty("anio_publicacion")
    private int anioPublicacion;
}
