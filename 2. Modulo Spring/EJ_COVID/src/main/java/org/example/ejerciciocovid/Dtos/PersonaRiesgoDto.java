package org.example.ejerciciocovid.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaRiesgoDto   {
    private String nombreCompleto;
    private Integer edad;
}
