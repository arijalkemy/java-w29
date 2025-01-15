package com.example.ejercicio_blog.dto.response;

public record ExceptionDto(String message) {
    public static ExceptionDto create(String message) {
        return new ExceptionDto(message);
    }
}
