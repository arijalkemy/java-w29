package com.example.ejercicio_deportistas.dto;

import com.example.ejercicio_deportistas.model.Deportista;

public record DeportistaDTO(
        String nombreCompleto,
        String nombreDeporte
){ public static DeportistaDTO convertirDTO(Deportista deportista) {
    return new DeportistaDTO(
            deportista.getNombre() + " " + deportista.getApellido(),
            deportista.getDeporte().getNombre());
}
}
