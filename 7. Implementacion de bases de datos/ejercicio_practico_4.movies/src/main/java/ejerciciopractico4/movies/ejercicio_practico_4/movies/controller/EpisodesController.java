package ejerciciopractico4.movies.ejercicio_practico_4.movies.controller;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.EpisodesDto;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.service.IEpisodesServices;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodesController {
    private final IEpisodesServices services;

    public EpisodesController(IEpisodesServices services) {
        this.services = services;
    }

    @GetMapping("/{idactor}")
    public ResponseEntity<List<EpisodesDto>> getEpisodesByActor(@PathVariable Long idactor) {
        return  ResponseEntity.ok(services.searchEpisodesByActor(idactor));
    }
}
