package com.org.meli.obrasliterarias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LiteraryWorkDto {
    private String id;
    private String name;
    private String author;
    private Integer numberOfPages;
    private String editorial;
    private String publicationYear;
}
