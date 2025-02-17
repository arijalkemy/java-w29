package com.example.implnosqlvivo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras_literarias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private int cantidadPaginas;
    private String editorial;
    private int anioPublicacion;
}
