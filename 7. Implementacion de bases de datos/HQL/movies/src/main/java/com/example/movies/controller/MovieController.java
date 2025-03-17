package com.example.movies.controller;

import com.example.movies.dto.response.ActorFavoriteMovieDto;
import com.example.movies.dto.response.MovieDto;
import com.example.movies.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private IMovieService iMovieService;

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<MovieDto>> getMoviesByActorRating(
            @PathVariable Double rating
    ){
        return ResponseEntity.ok(iMovieService.searchMoviesByActorRating(rating));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieDto>> getMoviesByGenre(
            @PathVariable String genre
    ){
        return ResponseEntity.ok(iMovieService.searchMoviesByGenre(genre));
    }
}
