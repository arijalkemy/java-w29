package com.pruebaa.pruebademo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "obras")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private int cantidad_de_paginas;
    private String editorial;
    private int anio_primer_publicacion;
}
