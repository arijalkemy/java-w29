package com.example.students.util;

import com.example.students.dto.*;
import com.example.students.model.Actor;
import com.example.students.model.Episode;
import com.example.students.model.Movie;
import com.example.students.model.Season;
import com.example.students.model.Serie;

import java.util.List;

public class Mapper {
    public static MovieDto toMovieDto(Movie m) {
        return new MovieDto(
                m.getTitle(),
                m.getRating(),
                m.getAwards(),
                m.getReleaseDate(),
                m.getLength(),
                m.getGenre() != null ? m.getGenre().getName() : "Sin Género"
        );
    }

    public static ActorDto toActorDto(Actor a) {
        return new ActorDto(
                a.getFirstName(),
                a.getLastName(),
                a.getRating()
        );
    }

    public static SerieDto toSerieDto(Serie s) {
        return new SerieDto(
                s.getTitle(),
                s.getReleaseDate(),
                s.getEndDate(),
                s.getSeasons().size(),
                s.getGenre() != null ? s.getGenre().getName() : "Sin Género"
        );
    }

    public static ActorWithFavMovieDto toActorWithFavMovieDto(Actor a) {
        return new ActorWithFavMovieDto(
                a.getFirstName(),
                a.getLastName(),
                a.getFavoriteMovie() != null ? a.getFavoriteMovie().getTitle() : "Sin Película Favorita"
        );
    }

    public static EpisodeDto toEpisodeDto(Episode e) {
        return new EpisodeDto(
                e.getTitle(),
                e.getNumber(),
                e.getRating(),
                e.getReleaseDate()
        );
    }

    public static SeasonDto toSeasonDto(Season season, List<Episode> episodes) {
        return new SeasonDto(
                season.getTitle(),
                season.getNumber(),
                episodes.stream()
                        .map(Mapper::toEpisodeDto)
                        .toList()
        );
    }
}
