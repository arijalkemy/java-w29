package com.mercadolibre.final_project_bootcamp_esp_2.controller;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.RegisteredUserDto;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.UserDto;
import com.mercadolibre.final_project_bootcamp_esp_2.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<RegisteredUserDto> registerOne(@RequestBody @Valid UserDto newUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.registerOne(newUser));
    }

}