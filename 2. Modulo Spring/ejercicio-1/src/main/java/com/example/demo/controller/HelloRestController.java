package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    //Aca coloco el nombre del endpoint al que voy a acceder
    @GetMapping("/sayHello")
    public String sayHello(String name) {
        return "Hello World";
    }

    @GetMapping("/factorial/{n}")
    public int factorial(@PathVariable int n){
        if(n==0) {
            return 1;
        }
        return n*factorial(n-1);
    }

    @GetMapping("/sayHello/{name}") //Le puedo pasar un parametro como variable
    //Como lo paso por direccion, debo colocar que es un path variable lo que recibe
    //el metodo
    public String sayHello2(@PathVariable String name) {
        return "Hello" + name;
    }
}
