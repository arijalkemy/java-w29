package spring.codigoMorse.domain;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class CodigoMorse {
    private static final Map<String, String> MORSE_CODES = new HashMap<>();

    static {
        MORSE_CODES.put(".-", "A");
        MORSE_CODES.put("-...", "B");
        MORSE_CODES.put("-.-.", "C");
        MORSE_CODES.put("-..", "D");
        MORSE_CODES.put(".", "E");
        MORSE_CODES.put("..-.", "F");
        MORSE_CODES.put("--.", "G");
        MORSE_CODES.put("....", "H");
        MORSE_CODES.put("..", "I");
        MORSE_CODES.put(".---", "J");
        MORSE_CODES.put("-.-", "K");
        MORSE_CODES.put(".-..", "L");
        MORSE_CODES.put("--", "M");
        MORSE_CODES.put("-.", "N");
        MORSE_CODES.put("---", "O");
        MORSE_CODES.put(".--.", "P");
        MORSE_CODES.put("--.-", "Q");
        MORSE_CODES.put(".-.", "R");
        MORSE_CODES.put("...", "S");
        MORSE_CODES.put("-", "T");
        MORSE_CODES.put("..-", "U");
        MORSE_CODES.put("...-", "V");
        MORSE_CODES.put(".--", "W");
        MORSE_CODES.put("-..-", "X");
        MORSE_CODES.put("-.--", "Y");
        MORSE_CODES.put("--..", "Z");

        MORSE_CODES.put("-----", "0");
        MORSE_CODES.put(".----", "1");
        MORSE_CODES.put("..---", "2");
        MORSE_CODES.put("...--", "3");
        MORSE_CODES.put("....-", "4");
        MORSE_CODES.put(".....", "5");
        MORSE_CODES.put("-....", "6");
        MORSE_CODES.put("--...", "7");
        MORSE_CODES.put("---..", "8");
        MORSE_CODES.put("----.", "9");
    }

    @Getter
    private String codigo;

    public CodigoMorse(String codigo) {
        this.codigo = codigo.trim();
    }

    public String decode() {
        String[] words = this.codigo.split("   ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                if (letter == null || letter.trim().isEmpty()) {
                    return "Error en el codigo, revisar";
                }
                String decoded = MORSE_CODES.get(letter);
                if (decoded == null) {
                    return "Error en el codigo: simbolo no reconocido '" + letter + "' ";
                }
                stringBuilder.append(decoded);
            }
            stringBuilder.append(" ");
        }
        return "Traduccion: " + stringBuilder.toString().toUpperCase();
    }
}
