package com.org.meli.obrasliterarias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "literary_work")
public class LiteraryWork {

    @Id
    private String id;
    private String name;
    private String author;
    private Integer numberOfPages;
    private String editorial;
    private String publicationYear;
}
