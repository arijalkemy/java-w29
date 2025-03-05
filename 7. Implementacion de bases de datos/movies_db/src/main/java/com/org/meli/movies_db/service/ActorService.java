package com.org.meli.movies_db.service;

import com.org.meli.movies_db.dto.ActorDto;
import com.org.meli.movies_db.dto.ActorWithFavMovieDto;
import com.org.meli.movies_db.dto.ActorWithSeriesAndMoviesDto;
import com.org.meli.movies_db.dto.SerieWithEpisodesDto;

import java.util.List;

public interface ActorService {
    List<ActorDto> getAllByMovieTitle(String title);
    List<ActorDto> getAll();
    List<ActorDto> getAllByMinRating(Double minRating);
    List<ActorWithFavMovieDto> getAllWithFavMovie();
    List<SerieWithEpisodesDto> getEpisodes(Integer actorId);
    List<ActorWithSeriesAndMoviesDto> getWorks();
}