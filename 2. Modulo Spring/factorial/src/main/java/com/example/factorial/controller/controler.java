package com.example.factorial.controller;

import com.example.factorial.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factorial")
public class controler {
    @Autowired
    private Iservice service;
    @GetMapping("/{n}")
    public int factorial(@PathVariable int n) {
      return service.factorial(n);
    }
}
