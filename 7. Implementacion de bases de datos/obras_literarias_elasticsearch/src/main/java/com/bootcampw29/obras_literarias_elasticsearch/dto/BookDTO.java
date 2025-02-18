package com.bootcampw29.obras_literarias_elasticsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String id;
    private String title;
    private String author;
    private Integer numberOfPages;
    private String editorial;
    private Integer publicationYear;
}
