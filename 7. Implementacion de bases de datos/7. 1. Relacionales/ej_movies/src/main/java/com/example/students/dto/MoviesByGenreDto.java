package com.example.students.dto;

import java.util.List;

public record MoviesByGenreDto(
        String genre,
        List<String> movies
) { }
