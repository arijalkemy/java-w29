package com.example.ejercicio_blog.dto;

import com.example.ejercicio_blog.entity.EntradaBlog;

public record EntradaBlogDto(Integer id, String titulo, String nombreAutor) {

    public static EntradaBlogDto convertToDto(EntradaBlog entradaBlog) {
        return new EntradaBlogDto(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getNombreAutor());
    }
}
