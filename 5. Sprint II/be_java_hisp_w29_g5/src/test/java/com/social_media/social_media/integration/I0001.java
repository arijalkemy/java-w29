package com.social_media.social_media.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static com.social_media.social_media.utils.MessagesExceptions.FOLLOWED_USER_NOT_SELLER;
import static com.social_media.social_media.utils.MessagesExceptions.USER_NOT_FOUND;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class I0001 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("I0001 - When trying to follow a user, then return 200 OK")
    void testPostFollowSellerSuccess() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 2L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(userId.intValue())))
                .andExpect(jsonPath("$.userIdToFollow", is(userIdToFollow.intValue())));
    }

    @Test
    @DisplayName("I0001 - When trying to follow a non-existent followed, then return 404 Not Found")
    void testPostFollowSellerNotFound() throws Exception {
        Long userId = 1L;
        Long nonExistentUserIdToFollow = 999L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, nonExistentUserIdToFollow))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is(USER_NOT_FOUND)));
    }

    @Test
    @DisplayName("I0009 - When trying to follow a follower user, then return 404 Bad Request")
    void testPostFollowSellerBadRequestNotFound() throws Exception {
        Long userId = 999L;
        Long userIdToFollow = 1L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is(USER_NOT_FOUND)));
    }

    @Test
    @DisplayName("I0001 - When trying to follow a user that is not a seller, then return 400 Bad Request")
    void testPostFollowSellerBadRequest() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 12L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is(FOLLOWED_USER_NOT_SELLER)));
    }

}
