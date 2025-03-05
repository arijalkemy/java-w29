package com.org.meli.movies_db.controller;

import com.org.meli.movies_db.dto.ActorDto;
import com.org.meli.movies_db.dto.ActorWithFavMovieDto;
import com.org.meli.movies_db.dto.ActorWithSeriesAndMoviesDto;
import com.org.meli.movies_db.dto.SerieWithEpisodesDto;
import com.org.meli.movies_db.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/actors")
public class ActorsController {

    private final ActorService actorService;

    @GetMapping
    public ResponseEntity<List<ActorDto>> getAll() {
        return ResponseEntity.ok(actorService.getAll());
    }

    @GetMapping("/movie-title/{title}")
    public ResponseEntity<List<ActorDto>> getAllByMovieTitle(@PathVariable String title) {
        return ResponseEntity.ok(actorService.getAllByMovieTitle(title));
    }

    @GetMapping("/min-rating/{minRating}")
    public ResponseEntity<List<ActorDto>> getAllWithMinRating(@PathVariable Double minRating) {
        return ResponseEntity.ok(actorService.getAllByMinRating(minRating));
    }

    @GetMapping("/with-fav-movie")
    public ResponseEntity<List<ActorWithFavMovieDto>> getAllWithFavMovie() {
        return ResponseEntity.ok(actorService.getAllWithFavMovie());
    }


}