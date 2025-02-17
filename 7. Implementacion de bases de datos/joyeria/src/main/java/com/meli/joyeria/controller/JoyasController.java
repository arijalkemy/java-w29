package com.meli.joyeria.controller;

import com.meli.joyeria.service.IJoyaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoyasController {
    private final IJoyaService joyaService;


    public JoyasController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }


}
