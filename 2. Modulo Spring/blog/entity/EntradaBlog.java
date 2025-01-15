package com.example.blog.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
