package com.thiagoschreck.local.star_wars_api.dto.response;

public record CharacterResponseDTO(String name, Integer height, Integer mass, String gender, String homeworld, String species) {
}
