package com.example.demo.dto;

import com.example.demo.model.Deportista;

public record DeportistaDTO(
        String nombreCompleto,
        String nombreDeporte
){ public static DeportistaDTO convertirDTO(Deportista deportista) {
        return new DeportistaDTO(
                deportista.getNombre() + " " + deportista.getApellido(),
                deportista.getDeporte().getNombre());
    }
}
