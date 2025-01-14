package org.example.dto_responseentity_2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
}
