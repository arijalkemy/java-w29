package com.example.obras_literarias.dto;

import lombok.Data;

@Data
public class ObraLiterariaRequestDto {
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private String editorial;
    private Integer year;
}
