package com.example.codigomorse.controller;

import com.example.codigomorse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MorseController {
    @Autowired
    private MorseService morseService;

    @PostMapping("/MorseConvert")
    public String convertMorse(@RequestBody String morsecode) {
        return morseService.generateWord(morsecode);
    }
}
