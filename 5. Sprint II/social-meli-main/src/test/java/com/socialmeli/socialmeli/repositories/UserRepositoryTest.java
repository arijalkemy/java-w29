package com.socialmeli.socialmeli.repositories;

import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.utils.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() throws IOException {
        userRepository = new UserRepository();
        userRepository.loadDataBase();
    }

    @Test
    @DisplayName("#56 findByIdTest - should return user when user exists")
    void findByIdTest_whenUserExists_thenReturnUser() {
        // Arrange
        User expected = UserFactory.createSeller(1, "Agostina Avalle");

        // Act
        User result = userRepository.findById(expected.getId()).orElse(null);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("#57 findByIdTest - should return user when user doesn't exists")
    void findByIdTest_whenUserDoesntExists_thenReturnUser() {
        // Arrange
        Integer userId = 999;

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            userRepository.findById(userId).orElseThrow();
        });
    }

    @Test
    @DisplayName("#58 update - should update the user details correctly")
    void updateTest_whenUserExists_thenUpdateUser() {
        // Arrange
        User user = UserFactory.createBuyer(2, "Carolina Comba");
        user.setIsSeller(true);
        user.setName("Caro");

        // Act
        userRepository.update(user);

        // Assert
        User updated = userRepository.getUsers()
                .stream()
                .filter(u -> u.getId().equals(user.getId())).findFirst()
                .orElse(null);

        assertNotNull(updated);
        assertTrue(updated.getIsSeller());
        assertEquals("Caro", updated.getName());
    }
}
