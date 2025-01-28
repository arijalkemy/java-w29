package com.example.deportistas.utils;

import com.example.deportistas.dtos.DeportistaDto;
import com.example.deportistas.models.Persona;

public class Mapper {
    public static DeportistaDto toDto(Persona persona) {
        return new DeportistaDto(
                String.format("%s %s",persona.getNombre(), persona.getApellido()),
                persona.getDeporte().getNombre()
        );
    }
}
