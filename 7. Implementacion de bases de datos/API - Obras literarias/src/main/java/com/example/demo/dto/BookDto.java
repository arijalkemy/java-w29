package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDto {
    private String name;
    private String author;
    @JsonProperty("no_of_pages")
    private Integer noOfPages;
    private String editorial;
    @JsonProperty("first_published_year")
    private Integer firstPublishedYear;
}