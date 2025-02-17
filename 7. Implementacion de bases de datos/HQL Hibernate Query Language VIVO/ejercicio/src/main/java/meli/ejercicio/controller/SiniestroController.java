package meli.ejercicio.controller;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.model.Siniestro;
import meli.ejercicio.model.Vehiculo;
import meli.ejercicio.service.SiniestroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/siniestro")
@RequiredArgsConstructor
public class SiniestroController {
    private final SiniestroService siniestroService;

    @GetMapping
    public ResponseEntity<List<Siniestro>> findAll() {
        return ResponseEntity.ok(siniestroService.findAll());
    }
}
