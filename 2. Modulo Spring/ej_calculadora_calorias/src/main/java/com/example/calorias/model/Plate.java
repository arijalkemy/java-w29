package com.example.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
