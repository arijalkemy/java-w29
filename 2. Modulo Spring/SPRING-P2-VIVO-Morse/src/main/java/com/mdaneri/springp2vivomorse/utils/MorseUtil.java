package com.mdaneri.springp2vivomorse.utils;

import java.util.HashMap;
import java.util.Map;

public class MorseUtil {

    private static final Map<String, Character> MORSE_MAP = Map.ofEntries(
            Map.entry(".-", 'A'),
            Map.entry("-...", 'B'),
            Map.entry("-.-.", 'C'),
            Map.entry("-..", 'D'),
            Map.entry(".", 'E'),
            Map.entry("..-.", 'F'),
            Map.entry("--.", 'G'),
            Map.entry("....", 'H'),
            Map.entry("..", 'I'),
            Map.entry(".---", 'J'),
            Map.entry("-.-", 'K'),
            Map.entry(".-..", 'L'),
            Map.entry("--", 'M'),
            Map.entry("-.", 'N'),
            Map.entry("---", 'O'),
            Map.entry(".--.", 'P'),
            Map.entry("--.-", 'Q'),
            Map.entry(".-.", 'R'),
            Map.entry("...", 'S'),
            Map.entry("-", 'T'),
            Map.entry("..-", 'U'),
            Map.entry("...-", 'V'),
            Map.entry(".--", 'W'),
            Map.entry("-..-", 'X'),
            Map.entry("-.--", 'Y'),
            Map.entry("--..", 'Z'),
            Map.entry(".----", '1'),
            Map.entry("..---", '2'),
            Map.entry("...--", '3'),
            Map.entry("....-", '4'),
            Map.entry(".....", '5'),
            Map.entry("-....", '6'),
            Map.entry("--...", '7'),
            Map.entry("---..", '8'),
            Map.entry("----.", '9'),
            Map.entry("-----", '0'),
            Map.entry("..--..", '?'),
            Map.entry("-.-.--", '!'),
            Map.entry(".-.-.-", '.'),
            Map.entry("--..--", ',')
    );

    public static String parse(String code) {
        StringBuilder result = new StringBuilder();
        String[] words = code.split(" {3}");

        for (int i = 0; i < words.length; i++) {
            String[] letters = words[i].trim().split(" ");

            for (String morse : letters) {
                Character character = MORSE_MAP.get(morse);
                if (character != null)
                    result.append(character);
                else
                    System.out.println("Unknown morse code: " + morse);
            }

            if (i < words.length - 1)
                result.append(" ");
        }

        return result.toString();
    }

}
