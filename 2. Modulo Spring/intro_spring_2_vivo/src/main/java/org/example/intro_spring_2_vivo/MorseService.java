package org.example.intro_spring_2_vivo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {

    private static final Map<Character, String> morseCodeMap = new HashMap<>();

    static {
        String[] letters = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] numbers = {".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};

        for (int i = 0; i < letters.length; i++) {
            morseCodeMap.put((char) ('A' + i), letters[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            morseCodeMap.put((char) ('1' + i), numbers[i]);
        }
        morseCodeMap.put('0', "-----");
    }

    public String getTradcutionMorseToSpanish(String morseCode) {
        StringBuilder result = new StringBuilder();
        for (String word : morseCode.split("   ")) {
            for (String letter : word.split(" ")) {
                result.append(getLetterFromMorse(letter));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    private char getLetterFromMorse(String morseLetter) {
        return morseCodeMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(morseLetter))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(' ');
    }
}
