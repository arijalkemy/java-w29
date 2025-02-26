package com.obras.obrasliterarias.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Getter @Setter
@Document(indexName = "obraliteraria")
public class ObraLiteraria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String autor;
    private int cantidad_de_paginas;
    private String editorial;
    private int anio_primer_publicacion;
}
