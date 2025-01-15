package com.alkemy.codigoMorse_grupo7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/morse")
public class ControllerTest {

    Map<String, String> morseToText = new HashMap<>();
    Map<String, String> textToMorse = new HashMap<>();

    public ControllerTest(){
        textToMorse.put("A", ".-");
        textToMorse.put("B", "-...");
        textToMorse.put("C", "-.-.");
        textToMorse.put("D", "-..");
        textToMorse.put("E", ".");
        textToMorse.put("F", "..-.");
        textToMorse.put("G", "--.");
        textToMorse.put("H", "....");
        textToMorse.put("I", "..");
        textToMorse.put("J", ".---");
        textToMorse.put("K", "-.-");
        textToMorse.put("L", ".-..");
        textToMorse.put("M", "--");
        textToMorse.put("N", "-.");
        textToMorse.put("O", "---");
        textToMorse.put("P", ".--.");
        textToMorse.put("Q", "--.-");
        textToMorse.put("R", ".-.");
        textToMorse.put("S", "...");
        textToMorse.put("T", "-");
        textToMorse.put("U", "..-");
        textToMorse.put("V", "...-");
        textToMorse.put("W", ".--");
        textToMorse.put("X", "-..-");
        textToMorse.put("Y", "-.--");
        textToMorse.put("Z", "--..");
        textToMorse.put("0", "-----");
        textToMorse.put("1", ".----");
        textToMorse.put("2", "..---");
        textToMorse.put("3", "...--");
        textToMorse.put("4", "....-");
        textToMorse.put("5", ".....");
        textToMorse.put("6", "-....");
        textToMorse.put("7", "--...");
        textToMorse.put("8", "---..");
        textToMorse.put("9", "----.");
        textToMorse.put(".", ".-.-.-");
        textToMorse.put(",", "--..--");
        textToMorse.put("?", "..--..");
        textToMorse.put("!", "-.-.--");

        for (Map.Entry<String, String> entry : textToMorse.entrySet()) {
            morseToText.put(entry.getValue(), entry.getKey());
        }
    }

    @GetMapping("/{value}")
    public String generateMorse (@PathVariable String value) {
        return decodeMorse(value);
    }

    private String decodeMorse (String morse){
        StringBuilder decodedString = new StringBuilder();
        String[] morseArray = morse.split(" ");

        for (String morseChar : morseArray) {
            decodedString.append(morseToText.getOrDefault(morseChar, " "));
        }
        return decodedString.toString();
    }
}
