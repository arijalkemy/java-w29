package com.example.codigoMorse.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MorseCodeController {

  private final Map<String, Character> morseMap;

  public MorseCodeController() {
    morseMap = new HashMap<>(Map.ofEntries(
            Map.entry(".-", 'A'), Map.entry("-...", 'B'), Map.entry("-.-.", 'C'), Map.entry("-..", 'D'), Map.entry(".", 'E'),
            Map.entry("..-.", 'F'), Map.entry("--.", 'G'), Map.entry("....", 'H'), Map.entry("..", 'I'), Map.entry(".---", 'J'),
            Map.entry("-.-", 'K'), Map.entry(".-..", 'L'), Map.entry("--", 'M'), Map.entry("-.", 'N'), Map.entry("---", 'O'),
            Map.entry(".--.", 'P'), Map.entry("--.-", 'Q'), Map.entry(".-.", 'R'), Map.entry("...", 'S'), Map.entry("-", 'T'),
            Map.entry("..-", 'U'), Map.entry("...-", 'V'), Map.entry(".--", 'W'), Map.entry("-..-", 'X'), Map.entry("-.--", 'Y'),
            Map.entry("--..", 'Z'), Map.entry(".----", '1'), Map.entry("..---", '2'), Map.entry("...--", '3'),
            Map.entry("....-", '4'), Map.entry(".....", '5'), Map.entry("-....", '6'), Map.entry("--...", '7'),
            Map.entry("---..", '8'), Map.entry("----.", '9'), Map.entry("-----", '0'), Map.entry("..--..", '?'),
            Map.entry("-.-.--", '!'), Map.entry(".-.-.-", '.'), Map.entry("--..--", ',')
    ));
  }

  @PostMapping("/morse_code")
  public String translateMorseCode(@RequestBody Map<String, String> json) {
    return translateToLetters(json);
  }

  public String translateToLetters(Map<String, String> json) {
    String codigo = json.get("codigo");
    StringBuilder lettersTranslation = new StringBuilder();
    System.out.println(codigo);
    String[] morseWords = codigo.split(" {3}");

    for (String morseWord: morseWords) {
      String[] MorseLetters = morseWord.split(" ");
      System.out.println(MorseLetters);
      for (String morseLetter: MorseLetters) {
        if (morseMap.containsKey(morseLetter)) {
          lettersTranslation.append(morseMap.get(morseLetter)).append("");
        } else {
          System.out.println("MorseLetter not valid: " + morseLetter);
        }
      }
    }

    return lettersTranslation.toString().trim();
  }
}
