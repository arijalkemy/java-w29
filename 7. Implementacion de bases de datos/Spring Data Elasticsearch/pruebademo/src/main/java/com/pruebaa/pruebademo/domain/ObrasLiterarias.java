package com.pruebaa.pruebademo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "obraliteraria")
public class ObrasLiterarias {
    @Id
    private Long id;
    private String nombre;
    private String autor;
    private int cantidad_de_paginas;
    private String editorial;
    private int anio_primer_publicacion;
}
