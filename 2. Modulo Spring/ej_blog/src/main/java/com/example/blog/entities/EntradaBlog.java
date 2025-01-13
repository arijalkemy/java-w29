package com.example.blog.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EntradaBlog {

    private Long id;

    private String titulo;

    private String autor;

    private LocalDate fechaPublicacion;

}
