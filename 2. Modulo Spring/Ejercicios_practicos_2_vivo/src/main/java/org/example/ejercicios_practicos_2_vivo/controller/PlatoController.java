package org.example.ejercicios_practicos_2_vivo.controller;

import org.example.ejercicios_practicos_2_vivo.dto.PlatoResponseDto;
import org.example.ejercicios_practicos_2_vivo.service.IPlatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/platos")
@AllArgsConstructor
public class PlatoController {

    private final IPlatoService platoService;

    @GetMapping("/{nombre}")
    public ResponseEntity<PlatoResponseDto> getPlato(@PathVariable String nombre){
        return ResponseEntity.ok(platoService.getplato(nombre));
    }

    @GetMapping("/lista-platos")
    public ResponseEntity<List<PlatoResponseDto>> getAllPlatos(@RequestBody List<String> nombres){
        return  ResponseEntity.ok(platoService.getAllplatos(nombres));
    }


}
