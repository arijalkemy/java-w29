package com.mercadolibre.final_project_bootcamp_esp_32.unit.config;

import com.mercadolibre.final_project_bootcamp_esp_32.config.JwtFilter;
import com.mercadolibre.final_project_bootcamp_esp_32.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JwtFilterTest {

    @InjectMocks
    private JwtFilter jwtFilter;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain chain;

    private String validToken = "Bearer valid.token";
    private String username = "test@example.com";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        SecurityContextHolder.clearContext();
    }

    @Test
    public void testDoFilterInternal_ValidToken() throws ServletException, IOException {
        when(request.getHeader("Authorization")).thenReturn(validToken);
        when(jwtUtil.extractUsername("valid.token")).thenReturn(username);
        when(jwtUtil.validateToken("valid.token")).thenReturn(true);

        // Act
        jwtFilter.doFilterInternal(request, response, chain);

        // Assert
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        assertNotNull(auth);
        assertEquals(username, auth.getName());
        verify(chain).doFilter(request, response);
    }

    @Test
    public void testDoFilterInternal_InvalidToken() throws ServletException, IOException {
        when(request.getHeader("Authorization")).thenReturn(validToken);
        when(jwtUtil.extractUsername("valid.token")).thenReturn(username);
        when(jwtUtil.validateToken("valid.token")).thenReturn(false); // Simula un token no válido

        // Act
        jwtFilter.doFilterInternal(request, response, chain);

        // Assert
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(chain).doFilter(request, response);
    }

    @Test
    public void testDoFilterInternal_NoAuthHeader() throws ServletException, IOException {
        when(request.getHeader("Authorization")).thenReturn(null); // Sin header de autenticación

        // Act
        jwtFilter.doFilterInternal(request, response, chain);

        // Assert
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(chain).doFilter(request, response);
    }
}