package com.org.meli.movies_db.controller;

import com.org.meli.movies_db.dto.MovieDto;
import com.org.meli.movies_db.dto.MoviesByGenreDto;
import com.org.meli.movies_db.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<List<MovieDto>> getMoviesByGenre(@PathVariable Integer genreId) {
        return ResponseEntity.ok(movieService.getAllByGenreId(genreId));
    }

    @GetMapping("/min-actors-rating/{minRating}")
    public ResponseEntity<List<MovieDto>> getMoviesByMinActorsRating(@PathVariable Double minRating) {
        return ResponseEntity.ok(movieService.getAllByMinActorsRating(minRating));
    }

}