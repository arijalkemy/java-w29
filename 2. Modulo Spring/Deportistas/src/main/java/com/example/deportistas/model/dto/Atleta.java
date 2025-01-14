package com.example.deportistas.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Atleta {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}


