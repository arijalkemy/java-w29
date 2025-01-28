package com.example.deportistas.models;

import com.example.deportistas.enums.Nivel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deporte {
    private String nombre;

    private Nivel nivel;
}
