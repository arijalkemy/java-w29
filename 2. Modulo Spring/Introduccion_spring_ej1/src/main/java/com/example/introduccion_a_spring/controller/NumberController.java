package com.example.introduccion_a_spring.controller;


import com.example.introduccion_a_spring.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping("/numberTranslate")
    public String calculateNumber(@RequestParam int number) {
        return numberService.calculate(number);
    }
    

}
