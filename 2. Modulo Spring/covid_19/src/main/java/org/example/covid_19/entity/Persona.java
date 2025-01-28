package org.example.covid_19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;
}
