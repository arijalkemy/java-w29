package com.example.codigo_morze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()
public class CodigoMorze {

    @GetMapping("codigo-morze/{codigo}")
    public String traducirCodigoMorze(@PathVariable String codigo){
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

        return Arrays.stream(codigo
                .split(" {3}"))
                .map(
                        word->
                                Arrays
                                        .stream(word.split(" "))
                                        .map(l->
                                                letras.get(l))
                                        .collect(Collectors.joining(""))
                )
                .collect(Collectors.joining(" "));




    }
}
