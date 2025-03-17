package com.example.obrasliterarias.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obrasliterarias")
@Data
public class ObraLiteraria {
    @Id
    private String id;

    private String title;

    private String autor;

    private Integer pages;

    private String editorial;

    private Integer year;
}
