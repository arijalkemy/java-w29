package com.example.students.controller;

import com.example.students.dto.ActorDto;
import com.example.students.dto.ActorWithFavMovieDto;
import com.example.students.dto.ActorWithSeriesAndMoviesDto;
import com.example.students.dto.SerieWithEpisodesDto;
import com.example.students.service.ActorService;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
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
    public ResponseEntity<List<ActorDto>> getAllWithMinRating(
            @PathVariable @DecimalMin("0.0") @DecimalMax("10.0") Double minRating) {
        return ResponseEntity.ok(actorService.getAllByMinRating(minRating));
    }

    @GetMapping("/with-fav-movie")
    public ResponseEntity<List<ActorWithFavMovieDto>> getAllWithFavMovie() {
        return ResponseEntity.ok(actorService.getAllWithFavMovie());
    }

    @GetMapping("/episodes/{actorId}")
    public ResponseEntity<List<SerieWithEpisodesDto>> getEpisodes(@PathVariable @Positive Integer actorId) {
        return ResponseEntity.ok(actorService.getEpisodes(actorId));
    }

    @GetMapping("/works")
    public ResponseEntity<List<ActorWithSeriesAndMoviesDto>> getWorks() {
        return ResponseEntity.ok(actorService.getWorks());
    }
}
