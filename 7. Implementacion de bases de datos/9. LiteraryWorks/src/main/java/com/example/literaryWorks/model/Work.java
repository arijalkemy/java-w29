package com.example.literaryWorks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "work")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Work {
    @Id
    private String id;
    private String name;
    private String author;
    private Integer pages;
    private String publisher;
    private Integer publishedYear;
}
