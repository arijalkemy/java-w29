package com.example.deportistas.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Deporte deporte;
}
