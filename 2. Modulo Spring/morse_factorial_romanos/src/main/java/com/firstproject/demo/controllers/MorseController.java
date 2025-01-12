package com.firstproject.demo.controllers;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class MorseController {

    private final ParameterNamesModule parameterNamesModule;

    public MorseController(ParameterNamesModule parameterNamesModule) {
        this.parameterNamesModule = parameterNamesModule;
    }

    @GetMapping("/morse/{word}")
    public String morse(@PathVariable String word) {
        Map<String,String> letras = new HashMap<>();
        letras.put(".-","a");
        letras.put("-...","b");
        letras.put("-.-.","c");
        letras.put("-..","d");
        letras.put(".","e");
        letras.put("..-.","f");
        letras.put("--.","g");
        letras.put("....","h");
        letras.put("..","i");
        letras.put(".---","j");
        letras.put("-.-","k");
        letras.put(".-..","l");
        letras.put("--","m");
        letras.put("-.","n");
        letras.put("---","o");
        letras.put("--.-","q");
        letras.put(".-.","r");
        letras.put("...","s");
        letras.put("-","t");
        letras.put("..-","u");
        letras.put("...-","v");
        letras.put(".--","w");
        letras.put("-..-","x");
        letras.put("-.--","y");
        letras.put("--..","z");


        return List.of(word.split("   ")).
                stream()
                .map(w-> List.of(w.split(" "))
                        .stream()
                        .map(letter->letras.get(letter))
                        .collect(Collectors.joining(""))
                ).collect(Collectors.joining(""));
    }
}
