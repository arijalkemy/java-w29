package com.example.moviesHQL.service;

import com.example.moviesHQL.dto.response.ActorDTO;

import java.util.List;

public interface IActorService {
    List<ActorDTO> getActorsHasOneFavoriteMovie();
    List<ActorDTO> getActorsByRating(Double rating);
    List<ActorDTO> getActorsByMovieTitle(String title);
    List<ActorDTO> getActorsByAwardsMovies();
}
