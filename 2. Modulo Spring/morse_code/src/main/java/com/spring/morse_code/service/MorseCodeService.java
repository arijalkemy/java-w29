package com.spring.morse_code.service;

import com.spring.morse_code.repository.MorseCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MorseCodeService {
    @Autowired
    MorseCodeRepository morseCodeRepository;

    public String mapToSentence(String morseSentence) {
        List<String> morseWords = List.of(morseSentence.split("\\s{3}"));
        List<List<String>> morseLetters = morseWords.stream()
                .map(s -> List.of(s.split(" ")))
                .toList();

        return String.join(" ", mapToWords(morseLetters));
    }

    public List<String> mapToWords(List<List<String>> morseLetters) {
        return morseLetters.stream().map(this::toWord).toList();
    }

    private String toWord(List<String> morseWordLetters) {
        return String.join("", morseWordLetters.stream()
                .map(morseLetter ->
                        morseCodeRepository.getLetter(morseLetter)
                )
                .toList());
    }
}
