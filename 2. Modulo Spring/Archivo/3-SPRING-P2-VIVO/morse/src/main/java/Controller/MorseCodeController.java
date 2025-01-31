package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/morse")
class MorseCodeController {

    private static final Map<Character, String> MORSE_CODE_MAP = new HashMap<>();

    static {
        MORSE_CODE_MAP.put('A', ".-");
        MORSE_CODE_MAP.put('B', "-...");
        MORSE_CODE_MAP.put('C', "-.-.");
        MORSE_CODE_MAP.put('D', "-..");
        MORSE_CODE_MAP.put('E', ".");
        MORSE_CODE_MAP.put('F', "..-.");
        MORSE_CODE_MAP.put('G', "--.");
        MORSE_CODE_MAP.put('H', "....");
        MORSE_CODE_MAP.put('I', "..");
        MORSE_CODE_MAP.put('J', ".---");
        MORSE_CODE_MAP.put('K', "-.-");
        MORSE_CODE_MAP.put('L', ".-..");
        MORSE_CODE_MAP.put('M', "--");
        MORSE_CODE_MAP.put('N', "-.");
        MORSE_CODE_MAP.put('O', "---");
        MORSE_CODE_MAP.put('P', ".--.");
        MORSE_CODE_MAP.put('Q', "--.-");
        MORSE_CODE_MAP.put('R', ".-.");
        MORSE_CODE_MAP.put('S', "...");
        MORSE_CODE_MAP.put('T', "-");
        MORSE_CODE_MAP.put('U', "..-");
        MORSE_CODE_MAP.put('V', "...-");
        MORSE_CODE_MAP.put('W', ".--");
        MORSE_CODE_MAP.put('X', "-..-");
        MORSE_CODE_MAP.put('Y', "-.--");
        MORSE_CODE_MAP.put('Z', "--..");
        MORSE_CODE_MAP.put('1', ".----");
        MORSE_CODE_MAP.put('2', "..---");
        MORSE_CODE_MAP.put('3', "...--");
        MORSE_CODE_MAP.put('4', "....-");
        MORSE_CODE_MAP.put('5', ".....");
        MORSE_CODE_MAP.put('6', "-....");
        MORSE_CODE_MAP.put('7', "--...");
        MORSE_CODE_MAP.put('8', "---..");
        MORSE_CODE_MAP.put('9', "----.");
        MORSE_CODE_MAP.put('0', "-----");
    }

    @GetMapping("/encode/{text}")
    public String encodeToMorse(@PathVariable String text) {
        StringBuilder morse = new StringBuilder();
        text = text.toUpperCase();

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                morse.append("   ");
            } else {
                String code = MORSE_CODE_MAP.get(c);
                if (code != null) {
                    morse.append(code).append(" ");
                } else {
                    return "Error: Caracter no soportado: " + c;
                }
            }
        }
        return morse.toString().trim();
    }

    @GetMapping("/decode/{morse}")
    public String decodeFromMorse(@PathVariable String morse) {
        String[] words = morse.split("   ");
        StringBuilder text = new StringBuilder();

        for (String word : words) {
            for (String code : word.split(" ")) {
                char decodedChar = MORSE_CODE_MAP.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue().equals(code))
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse('?');
                text.append(decodedChar);
            }
            text.append(" ");
        }
        return text.toString().trim();
    }
}
