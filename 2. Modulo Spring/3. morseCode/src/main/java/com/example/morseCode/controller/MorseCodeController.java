package com.example.morseCode.controller;

import com.example.morseCode.model.MorseCode;
import org.springframework.web.bind.annotation.*;

@RestController
public class MorseCodeController {

    @GetMapping("/morseCode")
    public String getMorseCode(@RequestParam String text) {
        return MorseCode.getMorseCode(text);
    }

    @GetMapping("/morsePhrase")
    public String getPhraseByCode(@RequestParam String code) {
        return MorseCode.getPhraseByCode(code);
    }
}
