package com.practicaejerciciodcovid.practicacovid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer id;
    private Sintoma sintoma;
}
