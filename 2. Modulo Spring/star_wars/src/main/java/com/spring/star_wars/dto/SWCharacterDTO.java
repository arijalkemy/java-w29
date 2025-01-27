package com.spring.star_wars.dto;

public record SWCharacterDTO(
    String name,
    Integer height,
    Integer mass,
    String gender,
    String homeworld,
    String species
) {}
