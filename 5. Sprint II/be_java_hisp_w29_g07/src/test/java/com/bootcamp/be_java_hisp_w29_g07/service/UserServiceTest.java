package com.bootcamp.be_java_hisp_w29_g07.service;

import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import com.bootcamp.be_java_hisp_w29_g07.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w29_g07.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilUserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    /**
     * Unit Test to verify that an existing user is correctly retrieved.
     */
    @Test
    void givenExistingUserId_whenFindUserById_thenReturnUser() {
        Integer userId = 4;
        User mockUser = UtilUserFactory.getUser("jfeo", userId);
        when(userRepository.getUserById(userId)).thenReturn(Optional.of(mockUser));

        User userResult = userService.findUserById(userId);

        assertNotNull(userResult);
        assertEquals(mockUser, userResult);
        verify(userRepository, times(1)).getUserById(userId);
    }

    /**
     * Unit Test to verify that an exception is thrown when the user does not exist.
     */
    @Test
    void givenNonExistingUserId_whenFindUserById_thenThrowNotFoundException(){
        Integer userId = 99;
        when(userRepository.getUserById(userId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> userService.findUserById(userId));
        verify(userRepository, times(1)).getUserById(userId);
    }

    /**
     * Unit Test to verify that verifyUserExists returns true when the user exists.
     */
    @Test
    void givenExistingUserId_whenVerifyUserExists_thenReturnTrue() {
        Integer userId = 1;

        when(userRepository.existsById(userId)).thenReturn(true);

        boolean exists = userService.verifyUserExists(userId);

        assertTrue(exists);
    }

    /**
     * Unit Test to verify that verifyUserExists throws NotFoundException when the user does not exist.
     */
    @Test
    void givenNonExistingUserId_whenVerifyUserExists_thenThrowNotFoundException() {
        Integer userId = 99;

        when(userRepository.existsById(userId)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> userService.verifyUserExists(userId));
    }

}