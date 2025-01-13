package com.mercadolibre.javawave29.morsecode.controller;

import com.mercadolibre.javawave29.morsecode.service.MorseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morseCode")
public class MorseCodeController {

    private final MorseCodeService morseCodeService;

    @Autowired
    public MorseCodeController(MorseCodeService morseCodeService) {
        this.morseCodeService = morseCodeService;
    }

    @GetMapping("/from/{phrase}")
    public String fromMorse(@PathVariable String phrase) {
        return morseCodeService.fromMorse(phrase);
    }

    @GetMapping("/to/{phrase}")
    public String toMorse(@PathVariable String phrase) {
        return morseCodeService.toMorse(phrase);
    }
}
