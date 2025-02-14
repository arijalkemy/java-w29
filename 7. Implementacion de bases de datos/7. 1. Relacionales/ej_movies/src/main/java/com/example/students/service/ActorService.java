package com.example.students.service;

import com.example.students.dto.*;

import java.util.List;

public interface ActorService {
    List<ActorDto> getAllByMovieTitle(String title);

    List<ActorDto> getAll();

    List<ActorDto> getAllByMinRating(Double minRating);

    List<ActorWithFavMovieDto> getAllWithFavMovie();

    List<SerieWithEpisodesDto> getEpisodes(Integer actorId);

    List<ActorWithSeriesAndMoviesDto> getWorks();
}
