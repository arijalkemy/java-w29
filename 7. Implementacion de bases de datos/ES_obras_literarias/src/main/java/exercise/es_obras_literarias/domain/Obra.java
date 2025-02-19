package exercise.es_obras_literarias.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Getter @Setter
@Document(indexName = "obras_literarias")
public class Obra {

    @Id
    private Long id;

    private String nombre;
    private String autor;
    @Field(name = "cantidad_paginas")
    private Integer cantidadPaginas;
    private String editorial;
    @Field(name = "anio_publicacion")
    private Integer anioPublicacion;
}
