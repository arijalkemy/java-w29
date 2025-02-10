package com.social_media.social_media.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.response.FollowersCountResponseDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.repository.follow.FollowRepositoryImpl;
import com.social_media.social_media.repository.post.PostRepositoryImpl;
import com.social_media.social_media.utils.MessagesExceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class I0002 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FollowRepositoryImpl followRepository;

    @Autowired
    private PostRepositoryImpl postRepositoryImpl;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("I0002 - When trying to get followers count, then return followers count 200 OK")
    public void whenTryingToGetFollowersCount_thenReturnFollowersCount200OK() throws Exception {

        Long userId = 17L;
        String name = "Ricardo Kaka";
        Integer expectedFollowersCount = 1;

        Post newPost = TestUtils.createRandomPost(userId);

        postRepositoryImpl.add(newPost);

        followRepository.addFollow(16L, userId);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count/", userId))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        int statusCode = mvcResult.getResponse().getStatus();

        FollowersCountResponseDto actualResponse = objectMapper.readValue(jsonResponse,
                FollowersCountResponseDto.class);
        FollowersCountResponseDto expectedResponseDto = new FollowersCountResponseDto(userId, name,
                expectedFollowersCount);

        assertEquals(actualResponse, expectedResponseDto);
        assertThat(statusCode).isEqualTo(200);
    }

    @Test
    @DisplayName("I0002 - When trying to get followers count, then return error user not found 404")
    public void whenTryingToGetFollowersCount_thenReturnErrorUserNotFound404() throws Exception {

        Long userId = 100L;

        mockMvc.perform(get("/users/{userId}/followers/count/", userId)
                .contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is(MessagesExceptions.SELLER_ID_NOT_EXIST)))
                .andReturn();

    }

    @Test
    @DisplayName("I0002 - When trying to get followers count, then return error user is not seller")
    public void whenTryingToGetFollowersCount_thenReturnErrorUserIsNotSeller() throws Exception {

        Long userId = 12L;

        mockMvc.perform(get("/users/{userId}/followers/count/", userId)
                .contentType("application/json"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message", is(MessagesExceptions.FOLLOWED_USER_NOT_SELLER)))
                .andReturn();

    }

}
