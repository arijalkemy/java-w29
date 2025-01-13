package com.example.calorias.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Comida {

    private String name;

    private Integer calories;

}
