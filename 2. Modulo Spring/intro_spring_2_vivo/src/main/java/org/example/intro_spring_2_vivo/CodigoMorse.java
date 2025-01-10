package org.example.intro_spring_2_vivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorse {

    private final MorseService morseService;

    @Autowired
    public CodigoMorse(MorseService morseService) {
        this.morseService = morseService;
    }


    @GetMapping("/codigoMorse/{texto_morse}")
    public String codigoMorse(@PathVariable("texto_morse") String textoMorse) {
        return morseService.getTradcutionMorseToSpanish(textoMorse);
    }


}
