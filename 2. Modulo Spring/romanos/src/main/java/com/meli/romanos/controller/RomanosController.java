package com.meli.romanos.controller;

import com.meli.romanos.service.RomanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class RomanosController
{
    RomanService romanService;

    public RomanosController() {
        this.romanService = new RomanService();
    }

    @GetMapping("/numberToRoman/{number}")
    public String romansReturn(@PathVariable Integer number){

        return this.romanService.intToRoman(number);
    }
}
