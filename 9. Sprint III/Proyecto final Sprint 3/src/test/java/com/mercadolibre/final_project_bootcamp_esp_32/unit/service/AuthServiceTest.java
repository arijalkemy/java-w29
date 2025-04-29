package com.mercadolibre.final_project_bootcamp_esp_32.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.LoginRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.TokenResponse;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Buyer;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InternalUser;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.IBuyerRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.InternalUserRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.service.AuthService;
import com.mercadolibre.final_project_bootcamp_esp_32.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthServiceTest {
    @InjectMocks
    private AuthService authService;

    @Mock
    private IBuyerRepository buyerRepository;
    @Mock
    private InternalUserRepository internalUserRepository;

    @Mock
    private JwtUtil jwtUtil;

    private LoginRequestDto loginRequest;
    private Buyer buyer;
    @Mock
    private HttpServletRequest request;

    @Mock
    private Claims claims;

    private InternalUser internalUser;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configuración de prueba
        loginRequest = new LoginRequestDto();
        loginRequest.setEmail("test@example.com");
        loginRequest.setPassword("password123");

        buyer = new Buyer();
        buyer.setEmail("test@example.com");
        buyer.setPassword("password123");

        internalUser = new InternalUser();
        internalUser.setEmail("internal@example.com");
        internalUser.setPassword("internalPassword");

    }

    @Test
    public void testAuthenticate_Success() throws NotFoundException {
        when(buyerRepository.findByEmail(loginRequest.getEmail())).thenReturn(buyer);
        when(jwtUtil.generateToken(buyer.getEmail())).thenReturn("token123");

        TokenResponse response = authService.authenticate(loginRequest);

        assertNotNull(response);
        assertEquals("token123", response.getToken());
    }

    @Test
    public void testAuthenticate_NotFound() {
        when(buyerRepository.findByEmail(loginRequest.getEmail())).thenReturn(null);

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            authService.authenticate(loginRequest);
        });

        assertEquals("Buyer no encontrado.", thrown.getMessage());
    }

    @Test
    public void testAuthenticate_InvalidPassword() {
        buyer.setPassword("wrongPassword");
        when(buyerRepository.findByEmail(loginRequest.getEmail())).thenReturn(buyer);

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            authService.authenticate(loginRequest);
        });

        assertEquals("Password incorrecto.", thrown.getMessage());
    }

    @Test
    public void testValidateInternalUser_TokenNotFound() {
        when(jwtUtil.getToken(request)).thenReturn(null);

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            authService.validateInternalUser(request);
        });

        assertEquals("No se encontró token.", thrown.getMessage());
    }

    @Test
    public void testValidateBuyer_TokenNotFound() {
        when(jwtUtil.getToken(request)).thenReturn(null);

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            authService.validateBuyer(request);
        });

        assertEquals("No se encontró token.", thrown.getMessage());
    }

    @Test
    public void testValidateInternalUser_Success() {
        String token = "valid.token";
        when(jwtUtil.getToken(request)).thenReturn(token);
        Claims claims = mock(Claims.class);
        when(claims.get("sub", String.class)).thenReturn("internal@example.com");
        when(jwtUtil.decodeToken(token)).thenReturn(claims);
        when(internalUserRepository.findByEmail("internal@example.com")).thenReturn(internalUser);

        InternalUser response = authService.validateInternalUser(request);
        assertEquals(internalUser, response);
    }

    @Test
    public void testValidateBuyer_Success() {
        String token = "valid.token";

        when(jwtUtil.getToken(request)).thenReturn(token);
        when(jwtUtil.decodeToken(token)).thenReturn(claims);
        when(claims.get("sub", String.class)).thenReturn("test@example.com");
        when(buyerRepository.findByEmail("test@example.com")).thenReturn(buyer);

        Buyer response = authService.validateBuyer(request);

        assertEquals(buyer, response);
    }

}
