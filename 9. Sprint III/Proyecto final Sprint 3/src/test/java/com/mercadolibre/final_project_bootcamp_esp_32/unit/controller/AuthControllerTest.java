package com.mercadolibre.final_project_bootcamp_esp_32.unit.controller;

import com.mercadolibre.final_project_bootcamp_esp_32.controller.AuthController;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.LoginRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.TokenResponse;
import com.mercadolibre.final_project_bootcamp_esp_32.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class AuthControllerTest {
    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthService authService;

    private LoginRequestDto loginRequest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configuración de prueba
        loginRequest = new LoginRequestDto();
        loginRequest.setEmail("test@example.com");
        loginRequest.setPassword("password123");
    }

    @Test
    public void testAuthenticate_Success() {
        TokenResponse tokenResponse = new TokenResponse("token123");

        when(authService.authenticate(loginRequest)).thenReturn(tokenResponse);

        ResponseEntity<TokenResponse> response = authController.authenticate(loginRequest);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("token123", response.getBody().getToken());
    }
}
