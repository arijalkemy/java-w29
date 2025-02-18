package meli.ejercicio.controller;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.dto.IdPrendaDto;
import meli.ejercicio.dto.PrendaDTO;
import meli.ejercicio.service.PrendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
@RequiredArgsConstructor
public class PrendaController {

    private final PrendaService prendaService;

    @PostMapping()
    public ResponseEntity<IdPrendaDto> create(@RequestBody PrendaDTO prendaDTO) {
        return ResponseEntity.ok(prendaService.create(prendaDTO));
    }

    @GetMapping()
    public ResponseEntity<List<PrendaDTO>> getAll() {
        return ResponseEntity.ok(prendaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrendaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(prendaService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrendaDTO> update(@PathVariable Long id, @RequestBody PrendaDTO prendaDTO) {
        return ResponseEntity.ok(prendaService.update(id, prendaDTO));
    }
}
