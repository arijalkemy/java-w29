package com.bootcamp.blog.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Blog {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fecha;
}
