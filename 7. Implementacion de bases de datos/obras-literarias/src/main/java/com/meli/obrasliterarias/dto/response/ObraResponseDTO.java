package com.meli.obrasliterarias.dto.response;

import lombok.Data;

@Data
public class ObraResponseDTO {
    private String nombre;
    private String autor;
    private int cantidadPaginas;
    private String editorial;
    private int anioPublicacion;
}
