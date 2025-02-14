package com.example.students.service;

import com.example.students.dto.MovieDto;
import com.example.students.dto.MoviesByGenreDto;
import com.example.students.repository.MovieRepository;
import com.example.students.util.Mapper;
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
                        result -> result[0], // El primer valor es el género
                        java.util.stream.Collectors.mapping(result -> result[1], Collectors.toList()) // El segundo valor es el título de la película
                ));

        return groupedByGenre.entrySet().stream()
                .map(entry -> new MoviesByGenreDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
