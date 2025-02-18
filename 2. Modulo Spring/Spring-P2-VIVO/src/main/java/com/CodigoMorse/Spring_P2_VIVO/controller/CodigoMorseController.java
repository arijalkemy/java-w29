package com.CodigoMorse.Spring_P2_VIVO.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {

    @GetMapping("/{morse}")
    public String traduccionMorse(@PathVariable String morse) {
        Map<String, Character> diccionarioMorse = new HashMap<>();
        diccionarioMorse.put(".-", 'A');
        diccionarioMorse.put("-...", 'B');
        diccionarioMorse.put("-.-.", 'C');
        diccionarioMorse.put("-..", 'D');
        diccionarioMorse.put(".", 'E');
        diccionarioMorse.put("..-.", 'F');
        diccionarioMorse.put("--.", 'G');
        diccionarioMorse.put("....", 'H');
        diccionarioMorse.put("..", 'I');
        diccionarioMorse.put(".---", 'J');
        diccionarioMorse.put("-.-", 'K');
        diccionarioMorse.put(".-..", 'L');
        diccionarioMorse.put("--", 'M');
        diccionarioMorse.put("-.", 'N');
        diccionarioMorse.put("---", 'O');
        diccionarioMorse.put(".--.", 'P');
        diccionarioMorse.put("--.-", 'Q');
        diccionarioMorse.put(".-.", 'R');
        diccionarioMorse.put("...", 'S');
        diccionarioMorse.put("-", 'T');
        diccionarioMorse.put("..-", 'U');
        diccionarioMorse.put("...-", 'V');
        diccionarioMorse.put(".--", 'W');
        diccionarioMorse.put("-..-", 'X');
        diccionarioMorse.put("-.--", 'Y');
        diccionarioMorse.put("--..", 'Z');
        diccionarioMorse.put(".----", '1');
        diccionarioMorse.put("..---", '2');
        diccionarioMorse.put("...--", '3');
        diccionarioMorse.put("....-", '4');
        diccionarioMorse.put(".....", '5');
        diccionarioMorse.put("-....", '6');
        diccionarioMorse.put("--...", '7');
        diccionarioMorse.put("---..", '8');
        diccionarioMorse.put("----.", '9');
        diccionarioMorse.put("-----", '0');
        diccionarioMorse.put("..--..", '?');
        diccionarioMorse.put("-.-.--", '!');
        diccionarioMorse.put(".-.-.-", '.');
        diccionarioMorse.put("--..--", ',');

        for (Map.Entry<String, Character> d : diccionarioMorse.entrySet()) {
            String clave = d.getKey();

            if (clave == morse) {
                return diccionarioMorse.get(morse).toString();
            } else {
                return "Morse mal escrito";
            }
        }
        return "sadsd";
    }

}
