package com.org.meli.movies_db.dto;

import java.util.List;

public record SerieWithEpisodesDto(
        SerieDto serie,
        List<SeasonDto> seasons
) {
}