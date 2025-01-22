package com.example.dto;

import com.example.entities.Deporte;

import java.util.List;

public class PersonaDeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;

    // Constructor
    public PersonaDeportistaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDeporte() {
        return deporte;
    }
}
