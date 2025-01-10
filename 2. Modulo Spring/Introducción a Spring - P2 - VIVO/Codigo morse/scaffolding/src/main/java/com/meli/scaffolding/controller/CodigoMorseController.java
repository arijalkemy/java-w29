package com.meli.scaffolding.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/codigo-morse")
public class CodigoMorseController {

    Map<String, String> equivalencias = new HashMap<>(
            Map.ofEntries(
                    Map.entry(".-", "A"),
                    Map.entry("-...", "B"),
                    Map.entry("-.-.", "C"),
                    Map.entry("-..", "D"),
                    Map.entry(".", "E"),
                    Map.entry("..-.", "F"),
                    Map.entry("--.", "G"),
                    Map.entry("....", "H"),
                    Map.entry("..", "I"),
                    Map.entry(".---", "J"),
                    Map.entry("-.-", "K"),
                    Map.entry(".-..", "L"),
                    Map.entry("--", "M"),
                    Map.entry("-.", "N"),
                    Map.entry("---", "O"),
                    Map.entry(".--.", "P"),
                    Map.entry("--.-", "Q"),
                    Map.entry(".-.", "R"),
                    Map.entry("...", "S"),
                    Map.entry("-", "T"),
                    Map.entry("..-", "U"),
                    Map.entry("...-", "V"),
                    Map.entry(".--", "W"),
                    Map.entry("-..-", "X"),
                    Map.entry("-.--", "Y"),
                    Map.entry("--..", "Z"),
                    Map.entry(".----", "1"),
                    Map.entry("..---", "2"),
                    Map.entry("...--", "3"),
                    Map.entry("....-", "4"),
                    Map.entry(".....", "5"),
                    Map.entry("-....", "6"),
                    Map.entry("--...", "7"),
                    Map.entry("---..", "8"),
                    Map.entry("----.", "9"),
                    Map.entry("-----", "0"),
                    Map.entry("..--..", "?"),
                    Map.entry("-.-.--", "!"),
                    Map.entry(".-.-.-", "."),
                    Map.entry("--..--", ",")
            )
    );

    @GetMapping("/traducir")
    public String traducir(@RequestParam String codigoMorse) {
        String textoTraducido = "";

        String[] palabrasMorse = codigoMorse.split("   ");

        for (String palabraMorse : palabrasMorse) {
            String[] letrasMorse = palabraMorse.split(" ");
            for (String letraMorse : letrasMorse) {
                String letra = equivalencias.get(letraMorse);
                if (letra != null) {
                    textoTraducido += letra;
                } else {
                    textoTraducido += "?";
                }
            }
            textoTraducido += " ";
        }
        return textoTraducido.trim();
    }
}
