package com.bootcamp.elastic_obras.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
public class BookDto {
    private String name;
    private String author;
    @JsonProperty("no_of_pages")
    private int noOfPages;
    private String editorial;
    @JsonProperty("first_published_year")
    private int firstPublishedYear;
}
