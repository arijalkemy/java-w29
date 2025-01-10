package com.bootcamp.morse.controller;

import com.bootcamp.morse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/morse")
public class MorseController {

    private final MorseService morseService;

    @Autowired
    public MorseController(MorseService morseService) {
        this.morseService = morseService;
    }

    @GetMapping("/{query}")
    public ResponseEntity<String> transateToMorse(@PathVariable("query") String query) {
        return ResponseEntity.ok().body(morseService.generateMorse(query));
    }
}
