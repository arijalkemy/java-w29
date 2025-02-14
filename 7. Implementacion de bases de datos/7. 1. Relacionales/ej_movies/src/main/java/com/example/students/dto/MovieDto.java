package com.example.students.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record MovieDto (
        String title,
        Double rating,
        Integer awards,
        @JsonProperty("release_date")
        LocalDate releaseDate,
        Integer length,
        String genre
) {}
