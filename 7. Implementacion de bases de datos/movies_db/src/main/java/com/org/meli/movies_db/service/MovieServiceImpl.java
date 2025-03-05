package com.org.meli.movies_db.service;

import com.org.meli.movies_db.dto.MovieDto;
import com.org.meli.movies_db.dto.MoviesByGenreDto;
import com.org.meli.movies_db.repository.MovieRepository;
import com.org.meli.movies_db.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;

    @Override
    public List<MovieDto> getAll() {
        return repository.findAll()
                .stream()
                .map(Mapper::toMovieDto)
                .toList();
    }

    @Override
    public List<MovieDto> getAllByGenreId(Integer genreId) {
        return repository.findAllByGenreId(genreId)
                .stream()
                .map(Mapper::toMovieDto)
                .toList();
    }

    @Override
    public List<MovieDto> getAllByMinActorsRating(Double minRating) {
        return repository.findAllByMinActorsRating(minRating)
                .stream()
                .map(Mapper::toMovieDto)
                .toList();
    }

    @Override
    public List<MoviesByGenreDto> getAllByGenre() {
        List<String[]> results = repository.findMoviesGroupedByGenre();

        Map<String, List<String>> groupedByGenre = results.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        result -> result[0],
                        java.util.stream.Collectors.mapping(result -> result[1], Collectors.toList())
                ));

        return groupedByGenre.entrySet().stream()
                .map(entry -> new MoviesByGenreDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}