package com.mercadolibre.bootcamp.obrasliterarias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Document(indexName = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Book {

    @Id
    private String id;

    private String title;
    private String author;
    private Integer pagesCount;
    private String editorial;

    @Field(name = "publishedAt", type = FieldType.Date, format = DateFormat.date)
    private LocalDate publishedAt;

}
