package com.thiagoschreck.local.ej_codigo_morse.controller;

import com.thiagoschreck.local.ej_codigo_morse.dto.TraduccionDTO;
import com.thiagoschreck.local.ej_codigo_morse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/morse")
public class MorseController {

    @Autowired
    private MorseService morseService;

    @GetMapping
    public ResponseEntity<TraduccionDTO> traducirMorse(@RequestParam("input") String input) {
        return ResponseEntity.ok(morseService.traducir(input));
    }
}
