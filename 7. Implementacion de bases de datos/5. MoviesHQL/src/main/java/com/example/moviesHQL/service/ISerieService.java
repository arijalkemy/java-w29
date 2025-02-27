package com.example.moviesHQL.service;

import com.example.moviesHQL.dto.response.SerieDTO;

import java.util.List;

public interface ISerieService {
    List<SerieDTO> getSeriesBySeasons(Integer season);
}
