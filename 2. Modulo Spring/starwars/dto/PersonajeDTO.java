package com.api.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data

@AllArgsConstructor
public class PersonajeDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
}
