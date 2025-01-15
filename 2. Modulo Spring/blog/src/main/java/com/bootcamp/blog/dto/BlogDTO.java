package com.bootcamp.blog.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BlogDTO {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fecha;
}
