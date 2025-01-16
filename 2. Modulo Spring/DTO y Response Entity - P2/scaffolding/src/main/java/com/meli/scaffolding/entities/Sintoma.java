package com.meli.scaffolding.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private Long codigo;
    private String nombre;
    private int nivel_de_gravedad;
}
