package com.example.deportistas.dtos;

import com.example.deportistas.models.Persona;

public record DeportistaDto(
        String nombre,
        String apellido,
        String nombreDeporte) {

    public static DeportistaDto toDto(Persona persona) {
        return new DeportistaDto(
                persona.getNombre(),
                persona.getApellido(),
                persona.getDeporte().getNombre()
        );
    }

}
