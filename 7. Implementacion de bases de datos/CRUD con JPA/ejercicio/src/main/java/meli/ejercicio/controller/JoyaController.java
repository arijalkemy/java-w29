package meli.ejercicio.controller;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.dto.JoyaDto;
import meli.ejercicio.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
@RequiredArgsConstructor
public class JoyaController {
    private final JoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<Long> createJoya(JoyaDto joyaDto) {
        return ResponseEntity.ok(joyaService.create(joyaDto));
    }

    @GetMapping()
    public ResponseEntity<List<JoyaDto>> readAll() {
        return ResponseEntity.ok(joyaService.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoyaDto> readJoya(Long id) {
        return ResponseEntity.ok(joyaService.read(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoya(Long id) {
        joyaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JoyaDto> updateJoya(JoyaDto joyaDto) {
        return ResponseEntity.ok(joyaService.update(joyaDto));
    }
}
