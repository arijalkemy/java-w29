package com.example.students.dto;

import java.util.List;

public record ActorWithSeriesAndMoviesDto(
        ActorDto actor,
        List<String> movies,
        List<String> series
) { }
