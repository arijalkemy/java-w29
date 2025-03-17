package com.example.movies.controller;

import com.example.movies.dto.response.ActorDto;
import com.example.movies.dto.response.ActorFavoriteMovieDto;
import com.example.movies.service.IActorService;
import com.example.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private IActorService iActorService;

    @GetMapping("/actorfavoritemovie")
    public ResponseEntity<List<ActorFavoriteMovieDto>> getActorWhoHasAFavoriteMovie(){
        return ResponseEntity.ok(iActorService.searchActorWhoHasFavoriteMovie());
    }

    @GetMapping("/actorrating")
    public ResponseEntity<List<ActorDto>> getActorRatingGreaterThan(
            @RequestParam Double rating
    ){
        return ResponseEntity.ok(iActorService.searchActorActorRatingGreaterThan(rating));
    }

    @GetMapping("/actorbymovie/{movie}")
    public ResponseEntity<List<ActorDto>> getActorsByMovie(
            @PathVariable String movie
    ){
        return ResponseEntity.ok(iActorService.searchActorsByMovie(movie));
    }
}
