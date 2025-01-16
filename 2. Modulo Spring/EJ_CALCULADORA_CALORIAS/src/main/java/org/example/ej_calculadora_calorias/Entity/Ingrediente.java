package org.example.ej_calculadora_calorias.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private String name;
    private Integer calories;



}
