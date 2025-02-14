package com.example.students.controller;

import com.example.students.dto.MovieDto;
import com.example.students.dto.MoviesByGenreDto;
import com.example.students.service.MovieService;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
@Validated
public class MoviesController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<List<MovieDto>> getMoviesByGenre(@PathVariable @Positive Integer genreId) {
        return ResponseEntity.ok(movieService.getAllByGenreId(genreId));
    }

    @GetMapping("/min-actors-rating/{minRating}")
    public ResponseEntity<List<MovieDto>> getMoviesByMinActorsRating(
            @PathVariable @DecimalMin("0.0") @DecimalMax("10.0") Double minRating) {
        return ResponseEntity.ok(movieService.getAllByMinActorsRating(minRating));
    }

    @GetMapping("by-genre")
    public ResponseEntity<List<MoviesByGenreDto>> getMoviesByGenre() {
        return ResponseEntity.ok(movieService.getAllByGenre());
    }
}
