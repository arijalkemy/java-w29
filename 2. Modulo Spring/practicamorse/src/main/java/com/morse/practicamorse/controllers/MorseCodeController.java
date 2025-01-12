package com.morse.practicamorse.controllers;

import com.morse.practicamorse.Services.MorseCodeTranslator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/morse")
public class MorseCodeController {
    private final MorseCodeTranslator morseCodeTranslator;

    public MorseCodeController(MorseCodeTranslator morseCodeTranslator) {
        this.morseCodeTranslator = morseCodeTranslator;
    }

    @PostMapping("/traductor")
    public String translate(@RequestBody String inputMorseCode) {
        return morseCodeTranslator.translate(inputMorseCode);
    }
}
