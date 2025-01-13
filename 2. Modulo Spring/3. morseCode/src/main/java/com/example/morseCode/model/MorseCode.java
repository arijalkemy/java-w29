package com.example.morseCode.model;

import java.util.Arrays;
import java.util.List;

public enum MorseCode {
    A("A",".-"),
    B("B", "-..."),
    C("C", "-.-."),
    D("D", "-.."),
    E("E", "."),
    F("F","..-."),
    G("G","--."),
    H("H","...."),
    I("I",".."),
    J("J",".---"),
    K("K", "-.-"),
    L("L", ".-.."),
    M("M", "--"),
    N("N","-."),
    O("O","---"),
    P("P", ".--."),
    Q("Q", "--.-"),
    R("R", ".-."),
    S("S", "..."),
    T("T","-"),
    U("U", "..-"),
    V("V", "...-"),
    W("W", ".--"),
    X("X", "-..-"),
    Y("Y", "-.--"),
    Z("Z", "--.."),
    UNO("1", ".----"),
    DOS("2", "..---"),
    TRES("3", "...--"),
    CUATRO("4", "....-"),
    CINCO("5", "....."),
    SEIS("6", "-...."),
    SIETE("7", "--..."),
    OCHO("8", "---.."),
    NUEVE("9", "----."),
    CERO("0", "-----"),
    PREGUNTA("?", "..--.."),
    INTERROGACION("!", "-.-.--"),
    PUNTO(".",".-.-.-"),
    COMA(",", "--..--");

    private String letter;
    private String code;

    MorseCode(String letter, String code) {
        this.letter = letter;
        this.code = code;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static MorseCode getValueByLetter(String letter) {
        return Arrays.stream(MorseCode.values())
                .filter(morseCode -> morseCode.getLetter().equals(letter))
                .findFirst()
                .orElse(null);
    }

    public static MorseCode getLetterByCode(String code) {
        return Arrays.stream(MorseCode.values())
                .filter(morseCode -> morseCode.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public static String getMorseCode(String phrase) {
        StringBuilder morseResult = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            String letter = String.valueOf(phrase.charAt(i)).toUpperCase();
            MorseCode matchingCode = getValueByLetter(letter);

            if (matchingCode != null) {
                morseResult.append(matchingCode.getCode()).append(" ");
            } else if (letter.equals(" ")) {
                morseResult.append("   ");
            } else {
                morseResult.append("? ");
            }
        }

        return morseResult.toString().trim();
    }

    public static String getPhraseByCode(String code) {
        String[] words = code.split(" {3}");
        StringBuilder phrase = new StringBuilder();

        for(int i = 0; i < words.length; i++) {
            String[] letters = words[i].split(" ");
            for (int j = 0; j < letters.length; j++) {
                phrase.append(getLetterByCode(letters[j]).getLetter());
            }
            phrase.append(" ");
        }

        return phrase.toString();
    }
}
