package com.example.moviesHQL.controller;

import com.example.moviesHQL.dto.response.ActorDTO;
import com.example.moviesHQL.service.ActorServiceImpl;
import com.example.moviesHQL.service.IActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController {
    private final IActorService actorService;

    @GetMapping("/favorite_movie")
    public ResponseEntity<List<ActorDTO>> getActorsHasOneFavoriteMovie() {
        return ResponseEntity.ok(actorService.getActorsHasOneFavoriteMovie());
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<ActorDTO>> getActorsByRating(@PathVariable Double rating) {
        return ResponseEntity.ok(actorService.getActorsByRating(rating));
    }

    @GetMapping("/movie_title/{title}")
    public ResponseEntity<List<ActorDTO>> getActorsByMovieTitle(@PathVariable String title) {
        return ResponseEntity.ok(actorService.getActorsByMovieTitle(title));
    }

    @GetMapping("/movie_awards")
    public ResponseEntity<List<ActorDTO>> getActorsByAwardsMovies() {
        return ResponseEntity.ok(actorService.getActorsByAwardsMovies());
    }
}
