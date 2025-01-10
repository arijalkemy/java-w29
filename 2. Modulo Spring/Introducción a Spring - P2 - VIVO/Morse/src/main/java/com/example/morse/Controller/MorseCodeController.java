package com.example.morse.Controller;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseCodeController {
    private static final Map<String, Character> morseCode;

    static {
        morseCode = new HashMap<>();

        // Letters
        morseCode.put(".-", 'A');
        morseCode.put("-...", 'B');
        morseCode.put("-.-.", 'C');
        morseCode.put("-..", 'D');
        morseCode.put(".", 'E');
        morseCode.put("..-.", 'F');
        morseCode.put("--.", 'G');
        morseCode.put("....", 'H');
        morseCode.put("..", 'I');
        morseCode.put(".---", 'J');
        morseCode.put("-.-", 'K');
        morseCode.put(".-..", 'L');
        morseCode.put("--", 'M');
        morseCode.put("-.", 'N');
        morseCode.put("---", 'O');
        morseCode.put(".--.", 'P');
        morseCode.put("--.-", 'Q');
        morseCode.put(".-.", 'R');
        morseCode.put("...", 'S');
        morseCode.put("-", 'T');
        morseCode.put("..-", 'U');
        morseCode.put("...-", 'V');
        morseCode.put(".--", 'W');
        morseCode.put("-..-", 'X');
        morseCode.put("-.--", 'Y');
        morseCode.put("--..", 'Z');

        // Numbers
        morseCode.put(".----", '1');
        morseCode.put("..---", '2');
        morseCode.put("...--", '3');
        morseCode.put("....-", '4');
        morseCode.put(".....", '5');
        morseCode.put("-....", '6');
        morseCode.put("--...", '7');
        morseCode.put("---..", '8');
        morseCode.put("----.", '9');
        morseCode.put("-----", '0');

        // Punctuation
        morseCode.put("..--..", '?');
        morseCode.put("-.-.--", '!');
        morseCode.put(".-.-.-", '.');
        morseCode.put("--..--", ',');
    }

    private final ConfigurableWebServerFactory configurableWebServerFactory;

    public MorseCodeController(ConfigurableWebServerFactory configurableWebServerFactory) {
        this.configurableWebServerFactory = configurableWebServerFactory;
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

//        Arrays.stream(codigo.split("   ")).forEach();
    }


}
