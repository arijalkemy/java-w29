package com.meliBootcamp.Exceptions.dto;

public class ExceptionDTO {
    String mensaje;

    public ExceptionDTO(String mensaje){
        this.mensaje=mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
