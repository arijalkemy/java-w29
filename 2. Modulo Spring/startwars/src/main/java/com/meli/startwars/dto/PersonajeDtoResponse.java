package com.meli.startwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDtoResponse {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeWorld;
    private String species;
}
