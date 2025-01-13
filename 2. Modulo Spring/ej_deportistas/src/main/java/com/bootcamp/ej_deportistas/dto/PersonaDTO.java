package com.bootcamp.ej_deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}
