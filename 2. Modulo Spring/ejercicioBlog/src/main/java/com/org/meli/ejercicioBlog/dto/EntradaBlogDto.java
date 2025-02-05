package com.org.meli.ejercicioBlog.dto;

import com.org.meli.ejercicioBlog.entity.EntradaBlog;

public record EntradaBlogDto(Integer id, String titulo, String nombreAutor) {

    public static EntradaBlogDto convertToDto(EntradaBlog entradaBlog) {
        return new EntradaBlogDto(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getNombreAutor());
    }
}
