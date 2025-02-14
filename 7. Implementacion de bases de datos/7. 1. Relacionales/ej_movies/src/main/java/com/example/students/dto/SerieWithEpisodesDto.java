package com.example.students.dto;

import java.util.List;

public record SerieWithEpisodesDto(
        SerieDto serie,
        List<SeasonDto> seasons
) {
}
