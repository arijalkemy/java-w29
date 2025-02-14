package com.bootcamp.be_java_hisp_w29_g07.repository;

import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilUserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private IUserRepository userRepository;

    @BeforeEach
    void setUp() throws IOException {
        userRepository = new UserRepositoryImpl();
    }
    /**
     * Unit Test to verify that an existing user is correctly retrieved.
     */
    @Test
    void givenExistingUserId_whenGetUserById_thenReturnUser() {
        Integer userId = 4;
        User expectedUser = UtilUserFactory.getSeller(userId);

        Optional<User> result = userRepository.getUserById(userId);

        assertTrue(result.isPresent());
        assertEquals(expectedUser, result.get());
    }

    /**
     * Unit Test to verify that a non-existent user returns an empty Optional.
     */
    @Test
    void givenNonExistingUserId_whenGetUserById_thenReturnEmptyOptional() {
        Integer userId = 99;

        Optional<User> result = userRepository.getUserById(userId);

        assertTrue(result.isEmpty());
    }

}