package org.example.ej_movies.controller;

import lombok.RequiredArgsConstructor;
import org.example.ej_movies.service.IMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie/")
@RequiredArgsConstructor
public class MovieController {

    private final IMovieService service;

    @GetMapping("movieByRatingActor/{rating}")
    public ResponseEntity<?> finDMovieByRatingActor(@PathVariable Double rating) {

        return new ResponseEntity<>(service.finDMovieByRatingActor(rating), HttpStatus.OK);
    }

    @GetMapping("finMovieByGenre/{genre}")
    public ResponseEntity<?> finMovieByGenre(@PathVariable String genre) {

        return new ResponseEntity<>(service.finMovieByGenre(genre), HttpStatus.OK);
    }
}
