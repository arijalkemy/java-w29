package com.org.meli.ejercicioBlog.dto.response;

public record NuevaEntradaBlogDto(String message) {
    public static NuevaEntradaBlogDto create(String message){
        return new NuevaEntradaBlogDto(message);
    }
}
