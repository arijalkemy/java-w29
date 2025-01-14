package org.example.ejercicios_practicos_2_vivo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private String nombre;
    private int caloriasPorUnidad;
}
