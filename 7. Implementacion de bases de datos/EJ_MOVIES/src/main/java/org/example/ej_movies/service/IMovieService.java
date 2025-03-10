package org.example.ej_movies.service;

import org.example.ej_movies.dto.MovieDto;
import org.example.ej_movies.model.Movie;

import java.util.List;

public interface IMovieService {

    List<MovieDto> finDMovieByRatingActor(Double rating);
    List<MovieDto> finMovieByGenre(String genre);
}
