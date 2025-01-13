package com.example.ejercicio_morse.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CodigoMorseController {

    Map<String, String> tradCodigoMorse = new HashMap<>();

    public CodigoMorseController() {
        this.tradCodigoMorse = new HashMap<>();

        tradCodigoMorse.put(".-", "A");
        tradCodigoMorse.put("-...", "B");
        tradCodigoMorse.put("-.-.", "C");
        tradCodigoMorse.put("-..", "D");
        tradCodigoMorse.put(".", "E");
        tradCodigoMorse.put("..-.", "F");
        tradCodigoMorse.put("--.", "G");
        tradCodigoMorse.put("....", "H");
        tradCodigoMorse.put("..", "I");
        tradCodigoMorse.put(".---", "J");
        tradCodigoMorse.put("-.-", "K");
        tradCodigoMorse.put(".-..", "L");
        tradCodigoMorse.put("--", "M");
        tradCodigoMorse.put("-.", "N");
        tradCodigoMorse.put("---", "O");
        tradCodigoMorse.put(".--.", "P");
        tradCodigoMorse.put("--.-", "Q");
        tradCodigoMorse.put(".-.", "R");
        tradCodigoMorse.put("...", "S");
        tradCodigoMorse.put("-", "T");
        tradCodigoMorse.put("..-", "U");
        tradCodigoMorse.put("...-", "V");
        tradCodigoMorse.put(".--", "W");
        tradCodigoMorse.put("-..-", "X");
        tradCodigoMorse.put("-.--", "Y");
        tradCodigoMorse.put("--..", "Z");
        tradCodigoMorse.put("-----", "0");
        tradCodigoMorse.put(".----", "1");
        tradCodigoMorse.put("..---", "2");
        tradCodigoMorse.put("...--", "3");
        tradCodigoMorse.put("....-", "4");
        tradCodigoMorse.put(".....", "5");
        tradCodigoMorse.put("-....", "6");
        tradCodigoMorse.put("--...", "7");
        tradCodigoMorse.put("---..", "8");
        tradCodigoMorse.put("----.", "9");
        tradCodigoMorse.put("..--..", "?");
        tradCodigoMorse.put("-.-.--", "!");
        tradCodigoMorse.put("--..--", ",");
        tradCodigoMorse.put(".-.-.-", ".");
    }

    @PostMapping("/tradCodigoMorse")
    public ResponseEntity<String> tradCodigoMorse(@RequestBody String request) {

        try {
            String response = traduccion(request);
            return ResponseEntity.ok(response);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private String traduccion(String morse) {
        return Arrays.stream(morse.split(" {3}"))
                .map(p -> Arrays.stream(p.split(" "))
                        .map(codigo -> {
                            String caracter = tradCodigoMorse.get(codigo);
                            if (caracter == null) {
                                throw new IllegalArgumentException("Código Morse no válido: " + codigo);
                            }
                            return caracter;
                        })
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }
}
