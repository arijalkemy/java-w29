package com.meli.ej_blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogEntry {
    private Integer id;
    private String title;
    private String authorName;
    private String publishDate;
}
