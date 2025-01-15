package com.api.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
