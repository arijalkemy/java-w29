package com.example.students.service;

import com.example.students.dto.MovieDto;
import com.example.students.dto.MoviesByGenreDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAll();

    List<MovieDto> getAllByGenreId(Integer genreId);

    List<MovieDto> getAllByMinActorsRating(Double minRating);

    List<MoviesByGenreDto> getAllByGenre();
}
