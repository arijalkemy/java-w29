package com.mercadolibre.final_project_bootcamp_esp_2.unit.service.auth;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.UserDto;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.auth.AuthenticationRequest;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.auth.AuthenticationResponse;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.RegisteredUserDto;
import com.mercadolibre.final_project_bootcamp_esp_2.model.User;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.UserRole;
import com.mercadolibre.final_project_bootcamp_esp_2.service.UserService;
import com.mercadolibre.final_project_bootcamp_esp_2.service.auth.AuthenticationService;
import com.mercadolibre.final_project_bootcamp_esp_2.service.auth.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {

    @Mock
    private UserService userService;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationService authenticationService;

    @Test
    void testRegisterOne() {
        UserDto newUser = new UserDto();
        newUser.setUsername("testUser");
        newUser.setName("Test");

        User savedUser = new User();
        savedUser.setUsername("testUser");
        savedUser.setName("Test");
        savedUser.setRole(UserRole.BUYER);

        when(userService.registerOne(newUser)).thenReturn(savedUser);
        when(jwtService.generateToken(any(User.class), anyMap())).thenReturn("mockJwt");

        RegisteredUserDto result = authenticationService.registerOne(newUser);

        assertEquals("testUser", result.getUsername());
        assertEquals("mockJwt", result.getJwt());
        verify(userService, times(1)).registerOne(newUser);
    }

    @Test
    void testValidateToken_Valid() {
        String token = "validJwt";
        when(jwtService.extractUsername(token)).thenReturn("testUser");
        boolean result = authenticationService.validateToken(token);
        assertTrue(result);
    }

    @Test
    void testValidateToken_Invalid() {
        String token = "invalidJwt";
        when(jwtService.extractUsername(token)).thenThrow(new RuntimeException("Invalid token"));

        boolean result = authenticationService.validateToken(token);

        assertFalse(result);
    }

    @Test
    void loginTest() {
        // Arrange
        AuthenticationRequest request = new AuthenticationRequest("pepe", "password");
        User mockedUser = User
                .builder()
                .name("pepe")
                .username("pepe")
                .password("password")
                .role(UserRole.BUYER)
                .build();
        when(userService.findOneByUsername(anyString())).thenReturn(Optional.of(mockedUser));
        when(jwtService.generateToken(any(UserDetails.class), any(Map.class))).thenReturn("mockedJwt");

        // Act
        AuthenticationResponse response = authenticationService.login(request);

        // Assert
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        assertEquals("mockedJwt", response.getJwt());

    }
}
