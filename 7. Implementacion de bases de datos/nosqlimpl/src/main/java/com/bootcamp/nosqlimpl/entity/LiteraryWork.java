package com.bootcamp.nosqlimpl.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "literarywork")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LiteraryWork {
    @Id
    private String id;

    private String name;
    private String author;
    private Integer pageCount;
    private String publisher;
    private Integer publicationYear;
}
