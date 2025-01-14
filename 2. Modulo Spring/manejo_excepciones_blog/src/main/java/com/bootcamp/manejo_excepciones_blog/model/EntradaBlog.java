package com.bootcamp.manejo_excepciones_blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
    private Integer blogId;
    private String blogTitle;
    private String authorName;
    private LocalDate publishDate;
}
