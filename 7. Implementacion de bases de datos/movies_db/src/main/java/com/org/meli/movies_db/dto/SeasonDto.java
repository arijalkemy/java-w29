package com.org.meli.movies_db.dto;

import java.util.List;

public record SeasonDto(
        String title,
        Integer number,
        List<EpisodeDto> episodes
) {
}