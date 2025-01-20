package com.excercise.morse_code.controller;

import com.excercise.morse_code.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/morse")
public class MorserController {
    private final MorseService morseService;

    @Autowired
    public MorserController(MorseService morseService) {
        this.morseService = morseService;
    }
    @GetMapping("/translate")
    public String translate(@RequestParam String code){
        return morseService.translate(code);
    }
}
