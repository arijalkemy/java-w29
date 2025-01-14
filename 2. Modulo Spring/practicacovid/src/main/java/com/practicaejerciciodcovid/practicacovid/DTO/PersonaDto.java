package com.practicaejerciciodcovid.practicacovid.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String sintoma;
}
