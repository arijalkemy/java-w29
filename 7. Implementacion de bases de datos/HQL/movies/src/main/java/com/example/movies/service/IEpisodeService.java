package com.example.movies.service;

import com.example.movies.dto.response.EpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDto> searchEpisodesByActorName(String name, String lastname);
}
