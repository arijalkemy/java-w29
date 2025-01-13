package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Code;


@RestController
@RequestMapping("/morse")
public class MorseController {
    @GetMapping("/to-spanish")
    public String translateMorseCode(@RequestBody Code code) {
        String codeString = code.getCode();
        MorseCode obj = new MorseCode(codeString,true);
        return obj.getMeaning();
    }

    @GetMapping("/to-morse-code")
    public String convertToMorseCode(@RequestBody Code code) {
        String codeString = code.getCode();
        MorseCode obj = new MorseCode(codeString,false);
        return obj.getCode();
    }
    
}
