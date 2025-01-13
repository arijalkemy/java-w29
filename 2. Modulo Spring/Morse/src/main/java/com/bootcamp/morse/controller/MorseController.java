package com.bootcamp.morse.controller;

import com.bootcamp.morse.service.MorseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    public MorseController(MorseService morseService) {
        this.morseService = morseService;
    }

    private final MorseService morseService;

    @GetMapping("/translate/{code}")
    public String translateMorse(@PathVariable String code) {
        return morseService.translate(code);
    }
}
