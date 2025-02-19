package com.example.obras_literarias.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "bibloteca")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private String editorial;
    private Integer year;
}
