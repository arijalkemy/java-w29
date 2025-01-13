package com.example.introduccionspring.controller;

import com.example.introduccionspring.utils.MorseParse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/morse")
public class MorseRestController {
    @GetMapping("/encode/{text}")
    public String encode(@PathVariable String text) {
        return MorseParse.spanishToMorse(text);
    }

    @GetMapping("/decode/{morse}")
    public String decode(@PathVariable String morse) {
        return MorseParse.morseToSpanish(morse);
    }
}
