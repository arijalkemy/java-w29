package org.example.calcular_calorias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Platos {
    private String nombre;
    private Double peso;
    private Double calorias;
    List<Ingredientes> ingredientes;
}
