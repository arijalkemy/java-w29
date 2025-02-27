package com.example.moviesHQL.service;

import com.example.moviesHQL.dto.response.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDTO> getEpisodesByActor(String name);
}
