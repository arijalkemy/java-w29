package org.example.deportes.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}
