package com.meli.scaffolding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/romanos")
public class RomanosController {
    Map<Integer, String> romanos = new HashMap<>(
            Map.ofEntries(
                    Map.entry(1, "I"),
                    Map.entry(2, "II"),
                    Map.entry(3, "III"),
                    Map.entry(4, "IV"),
                    Map.entry(5, "V"),
                    Map.entry(6, "VI"),
                    Map.entry(7, "VII"),
                    Map.entry(8, "VIII"),
                    Map.entry(9, "IX"),
                    Map.entry(10, "X"),
                    Map.entry(11, "XI"),
                    Map.entry(12, "XII"),
                    Map.entry(13, "XIII"),
                    Map.entry(14, "XIV"),
                    Map.entry(15, "XV"),
                    Map.entry(50, "L"),
                    Map.entry(100, "C"),
                    Map.entry(500, "D"),
                    Map.entry(1000, "M")
            )
    );

    @GetMapping("/obtener/{numero}")
    public String obtenerNumeroRomano(@PathVariable Integer numero){
        return romanos.get(numero);
    }
}
