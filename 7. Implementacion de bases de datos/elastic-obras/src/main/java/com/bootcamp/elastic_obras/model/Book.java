package com.bootcamp.elastic_obras.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "books")
@Getter @Setter
public class Book {
    @Id
    private int id;
    private String name;
    private String author;
    @Field(name = "no_of_pages")
    private int noOfPages;
    private String editorial;
    @Field(name = "first_published_year")
    private int firstPublishedYear;
}
