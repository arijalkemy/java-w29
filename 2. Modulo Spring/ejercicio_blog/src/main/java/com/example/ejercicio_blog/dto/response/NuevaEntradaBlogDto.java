package com.example.ejercicio_blog.dto.response;

public record NuevaEntradaBlogDto(String message) {
    public static NuevaEntradaBlogDto create(String message){
        return new NuevaEntradaBlogDto(message);
    }
}
