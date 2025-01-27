package com.example.deportistas.dtos;

import com.example.deportistas.models.Persona;

public record DeportistaDto(
        String nombreCompleto,
        String nombreDeporte) {

    public static DeportistaDto toDto(Persona persona) {
        return new DeportistaDto(
                String.format("%s %s",persona.getNombre(), persona.getApellido()),
                persona.getDeporte().getNombre()
        );
    }

}
