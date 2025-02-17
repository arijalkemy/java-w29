package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.controler;

import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto.MessageDto;
import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto.SiniestroDto;
import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {

    @Autowired
    private final ISiniestroService service;

    public SiniestroController(ISiniestroService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> postSiniestro(@RequestBody SiniestroDto siniestroDto) {
        return ResponseEntity.ok(service.saveSiniestro(siniestroDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<SiniestroDto>> getAllSiniestros() {
        return ResponseEntity.ok(service.getSiniestros());
    }
}
