package com.example.codigomorse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MorseController {

    private final MorseService morseService;

    @Autowired
    public MorseController(MorseService morseService) {
        this.morseService = morseService;
    }

    @PostMapping("/traducir-morse")
    public ResponseEntity<String> traducirMorse(@RequestBody String morseCode) {
        if (morseCode == null || morseCode.trim().isEmpty()) {
            return new ResponseEntity<>("Se debe proporcionar un código Morse.", HttpStatus.BAD_REQUEST);
        }

        try {
            String translatedText = morseService.translateMorseToText(morseCode);
            return new ResponseEntity<>(translatedText, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error en la traducción del código Morse.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
