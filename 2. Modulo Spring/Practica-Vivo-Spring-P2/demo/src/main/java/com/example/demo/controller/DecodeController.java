package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.DecodeService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
public class DecodeController {

    private final DecodeService decodeService;

    @GetMapping("/morse")
    public String getDecodedMorse(@RequestParam String morse) {
        return decodeService.decodedMorse(morse);
    }

}
