package com.mercadolibre.final_project_bootcamp_esp_2.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.UserDto;
import com.mercadolibre.final_project_bootcamp_esp_2.model.User;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.UserRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    @DisplayName("Happy Path - registerOne")
    void registerOne() {
        UserDto dto = new UserDto();
        dto.setUsername("testUser");
        dto.setPassword("password123");
        dto.setRepeated_password("password123");
        dto.setName("Test User");
        User user = new User();
        user.setPassword("encodedPassword");
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        User result = userService.registerOne(dto);
        assertNotNull(result);
        assertEquals(user.getUsername(), result.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Sad Path - registerOne Password Mismatch")
    void registerOnePasswordNotMatch() {
        UserDto newUser = new UserDto();
        newUser.setUsername("testUser");
        newUser.setPassword("password123");
        newUser.setRepeated_password("differentPassword");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.registerOne(newUser));
        assertEquals("Passwords don't match", exception.getMessage());
    }

    @Test
    @DisplayName("Sad Path - findOneByUsername Not Found")
    void findOneByUsernameNotFound() {
        String username = "unknownUser";
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());
        Optional<User> result = userService.findOneByUsername(username);
        assertFalse(result.isPresent());
        verify(userRepository, times(1)).findByUsername(username);
    }
}
