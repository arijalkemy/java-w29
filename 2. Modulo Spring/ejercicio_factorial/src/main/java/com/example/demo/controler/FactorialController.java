package com.example.demo.controler;

import com.example.demo.service.FactorialServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class FactorialController {
    private final FactorialServiceImp factorialService;

    public FactorialController(FactorialServiceImp factorialService) {
        this.factorialService = factorialService;
    }


    @GetMapping("/factorial/{num}")
    public Long factorial(@PathVariable Long num) {
        return  factorialService.factorial(num);
    }

}
