package com.example.demo.controller;

import com.example.demo.service.PlatoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class Controller {
    private final PlatoService platoService;

    @GetMapping("/calcularCalorias")


}
