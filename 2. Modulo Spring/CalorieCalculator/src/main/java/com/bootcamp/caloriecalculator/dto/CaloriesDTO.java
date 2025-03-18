package com.bootcamp.caloriecalculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CaloriesDTO(
        String name,
        int amount,
        @JsonProperty(value = "total_calories")
        int calories
) {
}
