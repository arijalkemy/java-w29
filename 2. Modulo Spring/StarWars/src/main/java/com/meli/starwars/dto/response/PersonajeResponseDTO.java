package com.meli.starwars.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonajeResponseDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeWorld;
    private String species;
}
