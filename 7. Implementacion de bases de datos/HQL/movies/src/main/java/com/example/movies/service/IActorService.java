package com.example.movies.service;

import com.example.movies.dto.response.ActorDto;
import com.example.movies.dto.response.ActorFavoriteMovieDto;

import java.util.List;

public interface IActorService {
    List<ActorFavoriteMovieDto> searchActorWhoHasFavoriteMovie();

    List<ActorDto> searchActorActorRatingGreaterThan(Double rating);

    List<ActorDto> searchActorsByMovie(String movie);
}
