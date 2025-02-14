package com.mercadolibre.bootcamp.joyerialasperlas.controller;

import com.mercadolibre.bootcamp.joyerialasperlas.dto.JoyaDto;
import com.mercadolibre.bootcamp.joyerialasperlas.dto.res.JoyaResponseDto;
import com.mercadolibre.bootcamp.joyerialasperlas.service.IJoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jewerly")
public class JoyeriaController {

    private final IJoyaService joyaService;

    public JoyeriaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<JoyaResponseDto> addJewerly(@RequestBody JoyaDto joyaDto) {
        return ResponseEntity.ok(joyaService.saveJoya(joyaDto));
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaDto>> getAll() {
        return ResponseEntity.ok(joyaService.getJoyas());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        joyaService.deleteJoya(id);
        return ResponseEntity.ok("Deleted");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<JoyaDto> deleteById(
            @RequestBody JoyaDto joyaDto,
            @PathVariable Integer id) {
        return ResponseEntity.ok(joyaService.update(id, joyaDto));
    }

}
