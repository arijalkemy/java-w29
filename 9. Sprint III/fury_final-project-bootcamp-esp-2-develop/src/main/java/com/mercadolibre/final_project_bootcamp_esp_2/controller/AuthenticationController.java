package com.mercadolibre.final_project_bootcamp_esp_2.controller;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.auth.AuthenticationRequest;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.auth.AuthenticationResponse;
import com.mercadolibre.final_project_bootcamp_esp_2.model.User;
import com.mercadolibre.final_project_bootcamp_esp_2.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authenticationService.login(authenticationRequest));
    }

    @GetMapping("/logged-user")
    public ResponseEntity<User> getLoggedInUser(){
        return ResponseEntity.ok(authenticationService.findLoggedInUser());
    }

}