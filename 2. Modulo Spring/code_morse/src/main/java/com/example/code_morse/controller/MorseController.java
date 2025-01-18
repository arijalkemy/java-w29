package com.example.code_morse.controller;

import com.example.code_morse.service.MorseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseController {
    private MorseService morseService;

    public MorseController(MorseService morseService) {
        this.morseService = morseService;
    }

    @GetMapping("/traductor/{code}")
    public ResponseEntity<String> translateMorse(@PathVariable String code) {
        try {
            return ResponseEntity.ok(morseService.translate(code));
        } catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
