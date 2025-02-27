package com.example.moviesHQL.controller;

import com.example.moviesHQL.dto.response.MovieDTO;
import com.example.moviesHQL.service.IMovieService;
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
public class MovieController {
    private final IMovieService movieService;

    @GetMapping("/actors_rating/{rating}")
    ResponseEntity<List<MovieDTO>> getMoviesByActorsRating(@PathVariable Double rating) {
        return ResponseEntity.ok(movieService.getMoviesByActorsRating(rating));
    }

    @GetMapping("/genre/{genre}")
    ResponseEntity<List<MovieDTO>> getMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/length/{length}")
    ResponseEntity<List<MovieDTO>> getMoviesByLength(@PathVariable Integer length) {
        return ResponseEntity.ok(movieService.getMoviesByLength(length));
    }
}
