package com.mercadolibre.final_project_bootcamp_esp_2.unit.service.auth;

import com.mercadolibre.final_project_bootcamp_esp_2.service.auth.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JwtServiceTest {

    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();
    }

    @Test
    void testGenerateToken() {
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("testUser");

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", "USER");

        String token = jwtService.generateToken(userDetails, extraClaims);

        assertNotNull(token);
        assertTrue(token.startsWith("eyJ"));
    }

    @Test
    void testExtractUsername() {
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("testUser");

        Map<String, Object> extraClaims = new HashMap<>();

        String token = jwtService.generateToken(userDetails, extraClaims);

        String username = jwtService.extractUsername(token);

        assertEquals("testUser", username);
    }
}
