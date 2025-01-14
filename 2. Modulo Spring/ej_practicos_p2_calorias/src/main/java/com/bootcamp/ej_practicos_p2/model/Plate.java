package com.bootcamp.ej_practicos_p2.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Plate {
    private String name;
    private Double weight;
    private List<Ingredient> ingredients;
}
