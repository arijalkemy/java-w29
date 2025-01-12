package exercise.codigo_morse.controllers;

import exercise.codigo_morse.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class CodigoMorseController {

    private static final Map<Character, String> morseCodeMap = new HashMap<>();

    public static Map<String, Character> crearMorseCodeMap(){
        Map<String, Character> morseCodeMap = new HashMap<>();

        // Letras
        morseCodeMap.put(".-", 'A');
        morseCodeMap.put("-...", 'B');
        morseCodeMap.put("-.-.", 'C');
        morseCodeMap.put("-..", 'D');
        morseCodeMap.put(".", 'E');
        morseCodeMap.put("..-.", 'F');
        morseCodeMap.put("--.", 'G');
        morseCodeMap.put("....", 'H');
        morseCodeMap.put("..", 'I');
        morseCodeMap.put(".---", 'J');
        morseCodeMap.put("-.-", 'K');
        morseCodeMap.put(".-..", 'L');
        morseCodeMap.put("--", 'M');
        morseCodeMap.put("-.", 'N');
        morseCodeMap.put("---", 'O');
        morseCodeMap.put(".--.", 'P');
        morseCodeMap.put("--.-", 'Q');
        morseCodeMap.put(".-.", 'R');
        morseCodeMap.put("...", 'S');
        morseCodeMap.put("-", 'T');
        morseCodeMap.put("..-", 'U');
        morseCodeMap.put("...-", 'V');
        morseCodeMap.put(".--", 'W');
        morseCodeMap.put("-..-", 'X');
        morseCodeMap.put("-.--", 'Y');
        morseCodeMap.put("--..", 'Z');

        // Números
        morseCodeMap.put("-----", '0');
        morseCodeMap.put(".----", '1');
        morseCodeMap.put("..---", '2');
        morseCodeMap.put("...--", '3');
        morseCodeMap.put("....-", '4');
        morseCodeMap.put(".....", '5');
        morseCodeMap.put("-....", '6');
        morseCodeMap.put("--...", '7');
        morseCodeMap.put("---..", '8');
        morseCodeMap.put("----.", '9');

        return morseCodeMap;
    }

    @GetMapping("decodificar")
    public String getMorseCode(@RequestBody Body body) {

        Map<String, Character> morseCodeMap = crearMorseCodeMap();
        StringBuilder result = new StringBuilder();

        String[] words = body.morseCodeText.split(" {3}");


        for(String word : words){
            String[] morseCodes = word.split(" ");
            for(String morseCode : morseCodes){
                result.append(morseCodeMap.get(morseCode));
            }

            result.append(" ");
        }

        return result.toString();
    }

    // Una alternativa utilizando programación funcional
    @GetMapping("decodificar-v2")
    public String getMorseCodeV2(@RequestBody Body body) {
        Map<String, Character> morseCodeMap = crearMorseCodeMap();

         return Arrays.stream(body.morseCodeText.split(" {3}"))
                        .map(word -> Arrays.stream(word.split(" "))
                                .map(morseCodeMap::get)
                                .map(String::valueOf)
                                .collect(Collectors.joining())
                        )
                 .collect(Collectors.joining(" "));
    }

}
