package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Deportista {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;
}
