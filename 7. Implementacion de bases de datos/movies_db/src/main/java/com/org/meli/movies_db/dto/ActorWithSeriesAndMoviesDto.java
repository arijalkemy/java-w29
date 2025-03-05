package com.org.meli.movies_db.dto;

import java.util.List;

public record ActorWithSeriesAndMoviesDto(
        ActorDto actor,
        List<String> movies,
        List<String> series
) { }