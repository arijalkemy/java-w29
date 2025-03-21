package com.bootcamp.obrasliterarias.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obra")
@Data
public class Obra {
    @Id
    private String id;
    private String titulo;
    private String autor;
    private int cantidadPaginas;
    private String editorial;
    private int anioPublicacion;
}
