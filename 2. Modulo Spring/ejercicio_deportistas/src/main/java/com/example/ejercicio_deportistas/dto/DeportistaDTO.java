package com.example.ejercicio_deportistas.dto;

import com.example.ejercicio_deportistas.model.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;

    public DeportistaDTO(Persona persona) {
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.deporte = persona.getDeporte().getNombre();
    }
}
