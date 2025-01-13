package com.meli.ej_deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonaDeporteDTO {
    private String nombrePersona;
    private String apellidoPersona;
    private String nombreDeporte;
}
