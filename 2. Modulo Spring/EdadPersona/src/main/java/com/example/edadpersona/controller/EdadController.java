package com.example.edadpersona.controller;

import com.example.edadpersona.service.EdadService;
import lombok.RequiredArgsConstructor; // Importar Lombok
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/calcularEdad")
@RequiredArgsConstructor // Esta anotación genera automáticamente un constructor con las propiedades finales
public class EdadController {
    private final EdadService edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<String> calcularEdadDesdeUrl(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        String mensaje = edadService.calcularEdad(fechaNacimiento);
        return ResponseEntity.ok(mensaje); // Devuelve 200 OK
    }

    @PostMapping("/agregarFechaNacimiento")
    public ResponseEntity<String> agregarFechaNacimiento(@RequestParam Integer dia, @RequestParam Integer mes, @RequestParam Integer anio) {
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Integer idUsuario = edadService.agregarUsuario(fechaNacimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fecha de nacimiento agregada con ID: " + idUsuario);
    }

    @GetMapping("/edad/{id}")
    public ResponseEntity<String> getEdadPorId(@PathVariable Integer id) {
        String edadRespuesta = edadService.EdadPorId(id);

        if (edadRespuesta.contains("El usuario no existe")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(edadRespuesta);
        }

        return ResponseEntity.ok(edadRespuesta);
    }
}