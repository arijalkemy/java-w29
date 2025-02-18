package ejerciciopractico4.movies.ejercicio_practico_4.movies.controller;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.ActorsDto;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.service.IActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsController {
    private final IActorsService service;

    public ActorsController(IActorsService service) {
        this.service = service;
    }

    @GetMapping("/favoriteMovies")
    public ResponseEntity<List<ActorsDto>> getActorsByFavoriteMovies(){
        return ResponseEntity.ok(service.searchByFavoriteMovie());
    }

    @GetMapping("/rating/{nro}")
    public ResponseEntity<List<ActorsDto>> getActorsByRating(@PathVariable Double nro){
        return ResponseEntity.ok(service.searchByRating(nro));
    }

    @GetMapping("/movies/{title}")
    public ResponseEntity<List<ActorsDto>> getActorsByTitle(@PathVariable String title){
        return ResponseEntity.ok(service.searchByMovies(title));
    }
}
