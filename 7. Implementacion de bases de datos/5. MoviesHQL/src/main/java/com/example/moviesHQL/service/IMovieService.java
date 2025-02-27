package com.example.moviesHQL.service;

import com.example.moviesHQL.dto.response.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> getMoviesByActorsRating(Double rating);
    List<MovieDTO> getMoviesByGenre(String genre);
    List<MovieDTO> getMoviesByLength(Integer length);
}
