package com.example.IntroSpring.controller;

import com.example.IntroSpring.service.ItraduccionMorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controler {

    @Autowired
    private ItraduccionMorse traductor;
    @GetMapping("/traducir/{s}")
    public String traduccion( @PathVariable String s){
        return traductor.traducir(s);
    }
    @GetMapping("/saludo")
    public String saludo(){
        return "Hola Mundo";
    }


}
