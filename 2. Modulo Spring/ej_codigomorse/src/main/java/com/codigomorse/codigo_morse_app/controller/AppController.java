package com.codigomorse.codigo_morse_app.controller;

import com.codigomorse.codigo_morse_app.model.MorseRequest;
import com.codigomorse.codigo_morse_app.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private final MorseService morseService;

    @Autowired
    public AppController(MorseService morseService) {
        this.morseService = morseService;
    }


    @PostMapping("/morse")
    public ResponseEntity<String> translateMorse(@RequestBody String morse) {
        String translatedText = this.morseService.translate(morse);
        return ResponseEntity.ok(translatedText);
    }


}
