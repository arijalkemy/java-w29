package com.mercadolibre.final_project_bootcamp_esp_2.integration;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.RegisteredUserDto;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest extends ControllerTest {

    @Test
    @DisplayName("Should register a new user and return a 201 status code")
    void registerNewUserTest() {

        // Arrange
        UserDto request = new UserDto("pepe", "pepe", "password", "password");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserDto> requestEntity = new HttpEntity<>(request, headers);

        // Act
        ResponseEntity<RegisteredUserDto> response = testRestTemplate.exchange(
                "/user",
                HttpMethod.POST,
                requestEntity,
                RegisteredUserDto.class
        );

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());


    }

}
