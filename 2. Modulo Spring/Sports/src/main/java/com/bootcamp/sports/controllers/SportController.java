package com.bootcamp.sports.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SportController {

    

    @GetMapping("/findSports")
    public String findSports() {

    }

}
