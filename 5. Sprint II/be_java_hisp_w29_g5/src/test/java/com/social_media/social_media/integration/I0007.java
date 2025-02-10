package com.social_media.social_media.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.social_media.social_media.utils.MessagesExceptions.NOT_FOLLOW_ALREADY_EXISTS;
import static com.social_media.social_media.utils.MessagesExceptions.USER_NOT_FOUND;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class I0007 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("I0007 - When trying to unfollow a user, then return 204 No Content")
    void testPostUnfollowSellerSuccess() throws Exception {
        Long userId = 2L;
        Long userIdToUnfollow = 1L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("I0007 - When trying to unfollow a non-existent user, then return 400")
    void testPostUnfollowSellerNotFound() throws Exception {
        Long userId = 1L;
        Long nonExistentUserIdToUnfollow = 999L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, nonExistentUserIdToUnfollow))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is(NOT_FOLLOW_ALREADY_EXISTS)));
    }

    @Test
    @DisplayName("I0007 - When trying to unfollow a user that is not followed, then return 400 Bad Request")
    void testPostUnfollowSellerBadRequest() throws Exception {
        Long userId = 1L;
        Long userIdToUnfollow = 11L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is(NOT_FOLLOW_ALREADY_EXISTS)));
    }
}