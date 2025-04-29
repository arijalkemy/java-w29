package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "books")
@Getter @Setter
public class Book {
    @Id
    private String id;
    private String name;
    private String author;
    @Field(name = "no_of_pages")
    private Integer noOfPages;
    private String editorial;
    @Field(name = "first_published_year")
    private Integer firstPublishedYear;
}
