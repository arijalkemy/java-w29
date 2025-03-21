package com.bootcamp.obrasliterarias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ObraDTO{
    private String id;
    private String titulo;
    private String autor;
    private int cantidadPaginas;
    private String editorial;
    private int anioPublicacion;
}
