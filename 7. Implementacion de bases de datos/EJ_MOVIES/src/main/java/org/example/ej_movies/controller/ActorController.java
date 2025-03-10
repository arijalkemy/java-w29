package org.example.ej_movies.controller;

import lombok.RequiredArgsConstructor;
import org.example.ej_movies.service.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final IActorService service;

    public ActorController(IActorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAllActors() {

        return new ResponseEntity<>(service.getAllActors(), HttpStatus.OK);
    }

    @GetMapping("/actorFavoriteMovie")
    public ResponseEntity<?> getActorsByFavoriteMovie() {
        return new ResponseEntity<>(service.getActorsByFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/actorsByRating/{rating}")
    public ResponseEntity<?> findAllByRating(@PathVariable Double rating) {
        return new ResponseEntity<>(service.findAllByRating(rating), HttpStatus.OK);
    }

    @GetMapping("/actorByMovie/{movie}")
    public ResponseEntity<?> findAllByMovie(@PathVariable String movie) {
        return new ResponseEntity<>(service.findAllByMovie(movie),HttpStatus.OK);
    }


}
