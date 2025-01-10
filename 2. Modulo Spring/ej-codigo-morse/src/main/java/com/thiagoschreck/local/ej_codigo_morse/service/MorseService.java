package com.thiagoschreck.local.ej_codigo_morse.service;

import com.thiagoschreck.local.ej_codigo_morse.dto.TraduccionDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MorseService {
    private static final Map<String, String> morseCodeMap = new HashMap<>();

    public MorseService() {
        precargarMapaCodigoMorse();
    }

    private void precargarMapaCodigoMorse() {
        morseCodeMap.put("", " ");
        morseCodeMap.put(".-", "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.", "F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..", "I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..", "L");
        morseCodeMap.put("--", "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-", "U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-", "X");
        morseCodeMap.put("-.--", "Y");
        morseCodeMap.put("--..", "Z");
        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2");
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6");
        morseCodeMap.put("--...", "7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");
        morseCodeMap.put("-----", "0");
        morseCodeMap.put(".-.-.-", ".");
        morseCodeMap.put("--..--", ",");
        morseCodeMap.put("..--..", "?");
        morseCodeMap.put("-.-.--", "!");
        morseCodeMap.put("-.-.-.", ";");
        morseCodeMap.put("---...", ":");
        morseCodeMap.put("-.--.", "(");
        morseCodeMap.put("-.--.-", ")");
        morseCodeMap.put(".-...", "&");
        morseCodeMap.put("-...-", "=");
        morseCodeMap.put(".-.-.", "+");
        morseCodeMap.put("-....-", "-");
        morseCodeMap.put("-..-.", "/");
        morseCodeMap.put("A", ".-");
        morseCodeMap.put("B", "-...");
        morseCodeMap.put("C", "-.-.");
        morseCodeMap.put("D", "-..");
        morseCodeMap.put("E", ".");
        morseCodeMap.put("F", "..-.");
        morseCodeMap.put("G", "--.");
        morseCodeMap.put("H", "....");
        morseCodeMap.put("I", "..");
        morseCodeMap.put("J", ".---");
        morseCodeMap.put("K", "-.-");
        morseCodeMap.put("L", ".-..");
        morseCodeMap.put("M", "--");
        morseCodeMap.put("N", "-.");
        morseCodeMap.put("O", "---");
        morseCodeMap.put("P", ".--.");
        morseCodeMap.put("Q", "--.-");
        morseCodeMap.put("R", ".-.");
        morseCodeMap.put("S", "...");
        morseCodeMap.put("T", "-");
        morseCodeMap.put("U", "..-");
        morseCodeMap.put("V", "...-");
        morseCodeMap.put("W", ".--");
        morseCodeMap.put("X", "-..-");
        morseCodeMap.put("Y", "-.--");
        morseCodeMap.put("Z", "--..");
        morseCodeMap.put("1", ".----");
        morseCodeMap.put("2", "..---");
        morseCodeMap.put("3", "...--");
        morseCodeMap.put("4", "....-");
        morseCodeMap.put("5", ".....");
        morseCodeMap.put("6", "-....");
        morseCodeMap.put("7", "--...");
        morseCodeMap.put("8", "---..");
        morseCodeMap.put("9", "----.");
        morseCodeMap.put("0", "-----");
        morseCodeMap.put(",", "--..--");
        morseCodeMap.put("?", "..--..");
        morseCodeMap.put("!", "-.-.--");
        morseCodeMap.put(";", "-.-.-.");
        morseCodeMap.put(":", "---...");
        morseCodeMap.put("(", "-.--.");
        morseCodeMap.put(")", "-.--.-");
        morseCodeMap.put("&", ".-...");
        morseCodeMap.put("=", "-...-");
        morseCodeMap.put("+", ".-.-.");
        morseCodeMap.put("/", "-..-.");
    }

    public TraduccionDTO traducir(String input) {
        final String traduccion = Arrays.stream(input.split(" "))
                .map(caracter -> Optional.ofNullable(morseCodeMap.get(caracter))
                        .orElse(""))
                .collect(Collectors.joining());
        return new TraduccionDTO(input, traduccion);
    }
}