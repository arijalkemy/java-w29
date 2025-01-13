package com.deportistas.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeportistaDto {
    private String nombre;
    private String apellido;
    private String deporte;
}