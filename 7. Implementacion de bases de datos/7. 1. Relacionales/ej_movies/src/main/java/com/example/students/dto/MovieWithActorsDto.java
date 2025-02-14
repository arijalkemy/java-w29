package com.example.students.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record MovieWithActorsDto(
        String title,
        Double rating,
        Integer awards,
        @JsonProperty("release_date")
        LocalDate releaseDate,
        Integer length,
        @JsonProperty("genre_name")
        List<ActorDto> actors
) {
}
