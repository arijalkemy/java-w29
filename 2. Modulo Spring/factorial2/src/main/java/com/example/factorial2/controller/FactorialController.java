package com.example.factorial2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    @GetMapping("/{base}")
    public String factorial(@PathVariable Long base) {
        return this.factorial2(base).toString();
    }

    private Long factorial2(Long n) {
        if (n == 0) {
            return 1l;
        }
        return n * factorial2(n - 1);
    }
}
