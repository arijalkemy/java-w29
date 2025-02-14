package com.example.students.dto;

import java.util.List;

public record SeriesByGenreDto(
        String genre,
        List<String> series
) {
}
