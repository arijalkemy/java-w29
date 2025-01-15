package com.example.ejercicio_blog.dto;

import com.example.ejercicio_blog.entity.EntradaBlog;

public record EntradaBlogDto(String titulo, String nombreAutor) {

    public static EntradaBlogDto convertToDto(EntradaBlog entradaBlog) {
        return new EntradaBlogDto(entradaBlog.getTitulo(), entradaBlog.getNombreAutor());
    }
}
