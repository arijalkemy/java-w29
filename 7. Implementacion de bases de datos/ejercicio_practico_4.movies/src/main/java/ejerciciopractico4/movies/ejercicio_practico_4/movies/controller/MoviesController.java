package ejerciciopractico4.movies.ejercicio_practico_4.movies.controller;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.MoviesDto;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.service.IMoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
     private final IMoviesService service;

    public MoviesController(IMoviesService service) {
        this.service = service;
    }

    @GetMapping("/actors/{rating}")
    public ResponseEntity<List<MoviesDto>> getMoviesByRatingActor(@PathVariable Double rating) {
        return ResponseEntity.ok(service.searchByRankingActors(rating));
    }

    @GetMapping("/genres/{name}")
    public ResponseEntity<List<MoviesDto>> getMoviesByGenre(@PathVariable String name) {
        return ResponseEntity.ok(service.searchByGenres(name));
    }
}
