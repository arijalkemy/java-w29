package com.bootcamp.ej_practicos_p2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plate {
    private String name;
    private Double weight;
    private List<Ingredient> ingredients;
}
