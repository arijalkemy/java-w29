package com.org.meli.movies_db.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record EpisodeDto (
        String title,
        Integer number,
        Double rating,
        @JsonProperty("release_date")
        LocalDate releaseDate
) {}