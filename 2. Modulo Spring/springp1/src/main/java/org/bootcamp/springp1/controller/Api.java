package org.bootcamp.springp1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Api {

    @GetMapping("/factorial/{numero}")
    public Integer factorial(@PathVariable Integer numero) {
        int factorial = 1;
        for (int i = 2; i <= numero; ++i) {
            factorial *= i;
        }
        return factorial;
    }
}
