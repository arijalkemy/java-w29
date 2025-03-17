package com.example.movies.service;

import com.example.movies.dto.response.ActorFavoriteMovieDto;
import com.example.movies.dto.response.MovieDto;

import java.util.List;

public interface IMovieService {

    List<MovieDto> searchMoviesByActorRating(Double rating);

    List<MovieDto> searchMoviesByGenre(String genre);
}
