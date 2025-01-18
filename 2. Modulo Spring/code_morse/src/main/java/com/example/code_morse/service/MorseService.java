package com.example.code_morse.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MorseService {

    private Map<String, String> codeMorse;

    public MorseService(){
        
        this.codeMorse = new HashMap<>();

        codeMorse.put(".-", "A");
        codeMorse.put("-...", "B");
        codeMorse.put("-.-.", "C");
        codeMorse.put("-..", "D");
        codeMorse.put(".", "E");
        codeMorse.put("..-.", "F");
        codeMorse.put("--.", "G");
        codeMorse.put("....", "H");
        codeMorse.put("..", "I");
        codeMorse.put(".---", "J");
        codeMorse.put("-.-", "K");
        codeMorse.put(".-..", "L");
        codeMorse.put("--", "M");
        codeMorse.put("-.", "N");
        codeMorse.put("---", "O");
        codeMorse.put(".--.", "P");
        codeMorse.put("--.-", "Q");
        codeMorse.put(".-.", "R");
        codeMorse.put("...", "S");
        codeMorse.put("-", "T");
        codeMorse.put("..-", "U");
        codeMorse.put("...-", "V");
        codeMorse.put(".--", "W");
        codeMorse.put("-..-", "X");
        codeMorse.put("-.--", "Y");
        codeMorse.put("--..", "Z");
        codeMorse.put("-----", "0");
        codeMorse.put(".----", "1");
        codeMorse.put("..---", "2");
        codeMorse.put("...--", "3");
        codeMorse.put("....-", "4");
        codeMorse.put(".....", "5");
        codeMorse.put("-....", "6");
        codeMorse.put("--...", "7");
        codeMorse.put("---..", "8");
        codeMorse.put("----.", "9");
        codeMorse.put("..--..", "?");
        codeMorse.put("-.-.--", "!");
        codeMorse.put("--..--", ",");
        codeMorse.put(".-.-.-", ".");
    }

    public String translate(String morse) {
        if (morse == null || morse.isEmpty()) {
            return "";
        }

        return Arrays.stream(morse.split("   "))
                .map(word -> Arrays.stream(word.split(" "))
                        .map(character -> codeMorse.getOrDefault(character, "?"))
                        .collect(Collectors.joining("")))
                .collect(Collectors.joining(" "));
    }

}
