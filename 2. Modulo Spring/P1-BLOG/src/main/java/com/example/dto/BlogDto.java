package com.example.dto;

import lombok.Data;

@Data
public class BlogDto {
    private Integer id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
