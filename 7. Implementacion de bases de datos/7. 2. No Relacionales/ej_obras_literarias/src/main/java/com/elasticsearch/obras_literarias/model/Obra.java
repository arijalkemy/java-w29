package com.elasticsearch.obras_literarias.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obras")
public class Obra {

    @Id
    private String id;

    private String nombre;

    private String autor;

    @JsonProperty("cantidad_paginas")
    private Integer cantidadPaginas;

    private String editorial;

    private Integer anio;
}
