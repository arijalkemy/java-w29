package com.example.students.service;

import com.example.students.dto.*;
import com.example.students.model.Actor;
import com.example.students.model.Episode;
import com.example.students.model.Serie;
import com.example.students.model.Movie;
import com.example.students.repository.ActorRepository;
import com.example.students.repository.MovieRepository;
import com.example.students.repository.SerieRepository;
import com.example.students.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    private final MovieRepository movieRepository;

    private final SerieRepository serieRepository;

    @Override
    public List<ActorDto> getAllByMovieTitle(String title) {
        return actorRepository.findByMovieTitle(title)
                .stream()
                .map(Mapper::toActorDto)
                .toList();
    }

    @Override
    public List<ActorDto> getAll() {
        return actorRepository.findAll()
                .stream()
                .map(Mapper::toActorDto)
                .toList();
    }

    @Override
    public List<ActorDto> getAllByMinRating(Double minRating) {
        return actorRepository.findAllByRatingGreaterThanEqual(minRating)
                .stream()
                .map(Mapper::toActorDto)
                .toList();
    }

    @Override
    public List<ActorWithFavMovieDto> getAllWithFavMovie() {
        return actorRepository.findAllWithFavMovie()
                .stream()
                .map(Mapper::toActorWithFavMovieDto)
                .toList();
    }

    @Override
    public List<SerieWithEpisodesDto> getEpisodes(Integer actorId) {
        List<Serie> series = serieRepository.findAllByActorId(actorId);

        return series.stream().map(serie -> {
            List<SeasonDto> seasonDtos = serie.getSeasons().stream()
                    .map(season -> {

                        // Obtenemos todos los episodios donde el actor participa
                        List<Episode> episodes = season.getEpisodes()
                                .stream()
                                .filter(e -> e.getActors()
                                        .stream()
                                        .anyMatch(actor -> actor.getId().equals(actorId)))
                                .toList();

                        // Solo mapeamos la temporada si tiene episodios
                        return episodes.isEmpty() ? null : Mapper.toSeasonDto(season, episodes);

                    }).filter(Objects::nonNull)
                    .toList();

            return new SerieWithEpisodesDto(Mapper.toSerieDto(serie), seasonDtos);
        }).toList();
    }

    @Override
    public List<ActorWithSeriesAndMoviesDto> getWorks() {
        List<Actor> actors = actorRepository.findAll();
        List<ActorWithSeriesAndMoviesDto> result = new ArrayList<>();

        actors.forEach(actor -> {
            List<Serie> series = serieRepository.findAllByActorId(actor.getId());
            List<Movie> movies = movieRepository.findAllByActorId(actor.getId());
            result.add(
                    new ActorWithSeriesAndMoviesDto(
                            Mapper.toActorDto(actor),
                            series.stream().map(Serie::getTitle).toList(),
                            movies.stream().map(Movie::getTitle).toList()
                    )
            );
        });
        return result;
    }
}
