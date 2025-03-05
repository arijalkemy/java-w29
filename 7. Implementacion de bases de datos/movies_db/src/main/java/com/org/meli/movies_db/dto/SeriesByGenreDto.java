package com.org.meli.movies_db.dto;

import java.util.List;

public record SeriesByGenreDto(
        String genre,
        List<String> series
) {
}