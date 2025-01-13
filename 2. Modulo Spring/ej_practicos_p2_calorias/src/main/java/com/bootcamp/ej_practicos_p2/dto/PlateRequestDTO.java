package com.bootcamp.ej_practicos_p2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlateRequestDTO {
    private String name;
    private Double weight;
    private List<String> ingredients;
}
