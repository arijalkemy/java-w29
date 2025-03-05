package com.example.literaryWorks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkDTO {
    private String id;
    private String name;
    private String author;
    private Integer pages;
    private String publisher;
    private Integer publishedYear;
}
