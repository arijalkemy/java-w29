package com.example.students.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ActorDto (
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        Double rating
) {
}
