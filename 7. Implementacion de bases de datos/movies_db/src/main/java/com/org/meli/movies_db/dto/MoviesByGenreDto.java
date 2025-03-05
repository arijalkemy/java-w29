package com.org.meli.movies_db.dto;

import java.util.List;

public record MoviesByGenreDto(
        String genre,
        List<String> movies
) { }