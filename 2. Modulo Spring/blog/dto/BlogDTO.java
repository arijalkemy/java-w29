package com.api.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogDTO {
    private Integer id;
    private String titulo;
    private String autor;
}
