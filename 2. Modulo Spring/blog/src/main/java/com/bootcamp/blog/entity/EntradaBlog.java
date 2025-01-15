package com.bootcamp.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
