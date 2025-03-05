package com.org.meli.movies_db.service;

import com.org.meli.movies_db.dto.MovieDto;
import com.org.meli.movies_db.dto.MoviesByGenreDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAll();
    List<MovieDto> getAllByGenreId(Integer genreId);
    List<MovieDto> getAllByMinActorsRating(Double minRating);
    List<MoviesByGenreDto> getAllByGenre();
}