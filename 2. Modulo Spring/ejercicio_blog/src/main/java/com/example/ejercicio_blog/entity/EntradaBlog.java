package com.example.ejercicio_blog.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private Date fechaPublicacion;
}
