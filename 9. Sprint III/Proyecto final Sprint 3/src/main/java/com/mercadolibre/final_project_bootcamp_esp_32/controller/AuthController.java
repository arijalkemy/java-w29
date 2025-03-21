package com.mercadolibre.final_project_bootcamp_esp_32.controller;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.LoginRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.TokenResponse;
import com.mercadolibre.final_project_bootcamp_esp_32.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> authenticate(@RequestBody final LoginRequestDto request){
        TokenResponse tokenResponse = authService.authenticate(request);
        return ResponseEntity.ok(tokenResponse);
    }
}
