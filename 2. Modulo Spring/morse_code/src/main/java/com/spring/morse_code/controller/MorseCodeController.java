package com.spring.morse_code.controller;

import com.spring.morse_code.service.MorseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/english")
public class MorseCodeController {
    @Autowired
    MorseCodeService morseCodeService;

    @GetMapping("/{morseSentence}")
    public ResponseEntity<?> getSentence(@PathVariable String morseSentence) {
        return ResponseEntity.ok(morseCodeService.mapToSentence(morseSentence));
    }
}
