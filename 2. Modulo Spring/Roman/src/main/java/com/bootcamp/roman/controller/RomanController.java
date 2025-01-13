package com.bootcamp.roman.controller;

import com.bootcamp.roman.service.RomanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanController {

    public RomanController(RomanService romanService) {
        this.romanService = romanService;
    }

    private final RomanService romanService;

    @GetMapping("/translate/{decimal}")
    public String translate(@PathVariable int decimal) {
        return romanService.roman(decimal);
    }

}
