package org.example.ej_movies.service;

import lombok.RequiredArgsConstructor;
import org.example.ej_movies.dto.MovieDto;
import org.example.ej_movies.model.Movie;
import org.example.ej_movies.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieServiceimpl implements IMovieService {

    private final MovieRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<MovieDto> finDMovieByRatingActor(Double rating) {
        List<Movie> movie = repository.finDMovieByRatingActor(rating);
        return movie.stream()
                .map(movie1 -> mapper.map(movie1, MovieDto.class))
                .toList();

    }

    @Override
    public List<MovieDto> finMovieByGenre(String genre) {
        List<Movie> movies = repository.finMovieByGenre(genre);
        return movies.stream()
                .map(movie -> mapper.map(movie, MovieDto.class))
                .toList();
    }
}
