package com.meli.morse.controllers;

import com.meli.morse.services.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MorseController{

    @Autowired
    private MorseService morseService;

    @GetMapping("/morse/{word}")
    public String morse(@PathVariable String word) {
     return morseService.generateMorse(word);
    }

}