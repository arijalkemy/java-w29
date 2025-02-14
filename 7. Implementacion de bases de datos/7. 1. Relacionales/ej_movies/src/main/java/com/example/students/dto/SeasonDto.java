package com.example.students.dto;

import java.util.List;

public record SeasonDto(
        String title,
        Integer number,
        List<EpisodeDto> episodes
) {
}
