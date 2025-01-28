package org.example.covid_19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private String code;
    private String nombre;
    private String nivelDeGravedad;
}
