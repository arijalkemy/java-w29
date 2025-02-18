package ejerciciopractico4.movies.ejercicio_practico_4.movies.controller;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.SerieDto;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.service.ISeriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {
    private final ISeriesService service;

    public SerieController(ISeriesService service) {
        this.service = service;
    }

    @GetMapping("/{cantidad}")
    public ResponseEntity<List<SerieDto>> getSeries(@PathVariable Integer cantidad) {
        return ResponseEntity.ok(service.searchSeriesBySeason(cantidad));
    }
}
