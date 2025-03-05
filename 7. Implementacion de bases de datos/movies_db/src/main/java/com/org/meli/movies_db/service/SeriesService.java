package com.org.meli.movies_db.service;

import com.org.meli.movies_db.dto.SerieDto;
import com.org.meli.movies_db.dto.SeriesByGenreDto;

import java.util.List;

public interface SeriesService {
    List<SerieDto> getAll();
    List<SerieDto> getAllWithMinSeasons(Integer minSeasons);
    List<SeriesByGenreDto> getAllByGenre();
}