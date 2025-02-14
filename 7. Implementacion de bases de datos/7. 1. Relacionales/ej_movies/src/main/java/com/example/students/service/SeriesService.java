package com.example.students.service;

import com.example.students.dto.SerieDto;
import com.example.students.dto.SeriesByGenreDto;

import java.util.List;

public interface SeriesService {
    List<SerieDto> getAll();

    List<SerieDto> getAllWithMinSeasons(Integer minSeasons);

    List<SeriesByGenreDto> getAllByGenre();
}
