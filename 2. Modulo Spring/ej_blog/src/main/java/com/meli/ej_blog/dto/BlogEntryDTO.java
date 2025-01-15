package com.meli.ej_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogEntryDTO {
    private Integer id;
    private String title;
    private String authorName;
    private String publishDate;
}
