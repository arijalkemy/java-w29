package com.bootcampw29.obras_literarias_elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private Integer numberOfPages;
    private String editorial;
    private Integer publicationYear;
}
