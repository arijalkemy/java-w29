package com.bootcamp.ej_deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private Integer nivel;
}
