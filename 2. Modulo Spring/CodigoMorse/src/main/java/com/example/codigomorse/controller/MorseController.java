package com.example.codigomorse.controller;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {
    private static final Map<String, Character> morseCode;

    static {
        morseCode = new HashMap<>();

        String[][] mappings = {
                {".-", "A"}, {"-...", "B"}, {"-.-.", "C"}, {"-..", "D"}, {".", "E"},
                {"..-.", "F"}, {"--.", "G"}, {"....", "H"}, {"..", "I"}, {".---", "J"},
                {"-.-", "K"}, {".-..", "L"}, {"--", "M"}, {"-.", "N"}, {"---", "O"},
                {".--.", "P"}, {"--.-", "Q"}, {".-.", "R"}, {"...", "S"}, {"-", "T"},
                {"..-", "U"}, {"...-", "V"}, {".--", "W"}, {"-..-", "X"}, {"-.--", "Y"},
                {"--..", "Z"}, {".----", "1"}, {"..---", "2"}, {"...--", "3"},
                {"....-", "4"}, {".....", "5"}, {"-....", "6"}, {"--...", "7"},
                {"---..", "8"}, {"----.", "9"}, {"-----", "0"},
                {"..--..", "?"}, {"-.-.--", "!"}, {".-.-.-", "±"}, {"--..--", ","}
        };

        for (String[] mapping : mappings) {
            morseCode.put(mapping[0], mapping[1].charAt(0));
        }
    }

    @GetMapping("morse/{codigo}")
    public String getMorseCode(@PathVariable String codigo){
        String result = "";
        for(String palabra : codigo.split("   ")) {
            for(String s : palabra.split(" ")) {
                result+= morseCode.get(s);
            }
            result += " ";

        }
        return result;

    }


}
