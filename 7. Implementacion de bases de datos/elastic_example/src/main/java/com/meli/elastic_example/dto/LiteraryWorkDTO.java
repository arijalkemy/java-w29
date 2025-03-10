package com.meli.elastic_example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LiteraryWorkDTO {
    private String id;
    private String name;
    private String author;
    private Integer numberOfPages;
    private String editorial;
    private String publicationYear;
}
