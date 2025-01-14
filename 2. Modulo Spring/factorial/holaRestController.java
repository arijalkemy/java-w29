package com.example.demo.API.factorial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class holaRestController {

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + " !";
    }
}
