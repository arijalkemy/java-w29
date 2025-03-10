package org.example.ej_movies.service;

import org.example.ej_movies.dto.ActorDto;

import java.util.List;

public interface IActorService {

    List<ActorDto> getAllActors();

    List<ActorDto> getActorsByFavoriteMovie();

    List<ActorDto> findAllByRating(Double rating);

    List<ActorDto> findAllByMovie(String movie);
}
