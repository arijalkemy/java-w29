package meli.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorse {

    //creacion map morse
    static Map<Character, String> morseCode = new HashMap<>();
    static String[] letters = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    static String[] numbers = {".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};

    static {
        for (int i = 0; i < letters.length; i++) {
            morseCode.put((char) ('A' + i), letters[i]);
        }
        for(int i = 0;i<numbers.length;i++){
        morseCode.put((char) ('1' + i), numbers[i]);
        }
        morseCode.put('0',"-----");
    }


    @GetMapping("/traducir")
    public String traducir(@RequestParam String morse) {
        //iterando por palabra y letra
        StringBuilder sb = new StringBuilder();
        for (String palabra : morse.split(" {3}")) {
            for (String letra : palabra.split(" ")) {
                sb.append(obtenerletra(letra));
            }
        sb.append(" ");
        }
        return sb.toString();
    }

    public static String obtenerletra(String letra) {
        //obteniendo letras del diccionario de codigo morse
        return String.valueOf(morseCode
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(letra)).map(Map.Entry::getKey)
                .findFirst()
                .orElse(' '));
    }

}