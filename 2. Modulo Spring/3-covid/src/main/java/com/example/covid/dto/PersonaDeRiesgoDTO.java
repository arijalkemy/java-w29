package com.example.covid.dto;

import com.example.covid.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDeRiesgoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;

    private List<Sintoma> sintomas;
}
