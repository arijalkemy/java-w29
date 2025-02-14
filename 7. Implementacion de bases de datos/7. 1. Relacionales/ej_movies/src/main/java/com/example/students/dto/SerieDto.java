package com.example.students.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record SerieDto (
        String title,
        @JsonProperty("release_date")
        LocalDate releaseDate,
        @JsonProperty("end_date")
        LocalDate endDate,
        @JsonProperty("number_of_seasons")
        Integer numberOfSeasons,
        String genre
) {
}
