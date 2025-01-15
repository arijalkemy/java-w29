package com.example.ejercicio_blog.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class EntradaBlogDto {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private Date fechaPublicacion;
}
