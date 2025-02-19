package com.bootcamp.elastic.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(indexName = "obras_literarias")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    @Field(name = "cantidad_paginas")
    private Integer cantidadPaginas;
    private String editorial;
    @Field(name = "anio_primer_publicacion")
    private Integer anioPublicacion;
}
