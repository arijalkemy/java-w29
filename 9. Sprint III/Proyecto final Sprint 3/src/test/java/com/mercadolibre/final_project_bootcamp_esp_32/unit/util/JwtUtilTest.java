package com.mercadolibre.final_project_bootcamp_esp_32.unit.util;

import com.mercadolibre.final_project_bootcamp_esp_32.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JwtUtilTest {

    private JwtUtil jwtUtil;
    private final String SECRET_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFuQHBydWViYS5jb20iLCJpYXQiOjE3NDIyMzYwMjgsImV4cCI6MTc0Mjg0MDgyOH0.uoyjnALQ4w0_6SsYK5gmOZV9nfsnkNVZ-6ZmJ_uYS_s"; // Define la clave secreta

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        jwtUtil = new JwtUtil();
        jwtUtil.setSecretKey(SECRET_KEY);
        jwtUtil.init();
    }

    @Test
    public void testGenerateToken() {
        String username = "test@example.com";
        String token = jwtUtil.generateToken(username);

        assertNotNull(token);
        assertTrue(token.startsWith("eyJ"));
    }

    @Test
    public void testExtractUsername() {
        String username = "test@example.com";
        String token = jwtUtil.generateToken(username);

        String extractedUsername = jwtUtil.extractUsername(token);
        assertEquals(username, extractedUsername);
    }

    @Test
    public void testValidateToken_ValidToken() {
        String token = jwtUtil.generateToken("test@example.com");

        boolean isValid = jwtUtil.validateToken(token);
        assertTrue(isValid);
    }

    @Test
    public void testValidateToken_InvalidToken() {
        String invalidToken = "invalid.token";

        boolean isValid = jwtUtil.validateToken(invalidToken);
        assertFalse(isValid);
    }

    @Test
    public void testDecodeToken_ValidToken() {
        String token = jwtUtil.generateToken("test@example.com");
        Claims claims = jwtUtil.decodeToken(token);

        assertNotNull(claims);
        assertEquals("test@example.com", claims.getSubject());
    }

    @Test
    public void testDecodeToken_InvalidToken() {
        String invalidToken = "invalid.token";

        Exception exception = assertThrows(RuntimeException.class, () -> {
            jwtUtil.decodeToken(invalidToken);
        });

        assertEquals("JWT token Invalido.", exception.getMessage());
    }

    @Test
    public void testGetToken() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("Authorization")).thenReturn("Bearer valid.token");

        String token = jwtUtil.getToken(request);
        assertEquals("valid.token", token);
    }

    @Test
    public void testGetToken_NoBearer() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("Authorization")).thenReturn("Invalid token");

        String token = jwtUtil.getToken(request);
        assertNull(token);
    }

    @Test
    public void testGetToken_NoHeader() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getHeader("Authorization")).thenReturn(null);

        String token = jwtUtil.getToken(request);
        assertNull(token);
    }
}