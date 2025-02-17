package com.bootcamp.nosqlimpl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiteraryWorkDTO {
    private String id;
    private String name;
    private String author;
    private Integer pageCount;
    private String publisher;
    private Integer publicationYear;
}
