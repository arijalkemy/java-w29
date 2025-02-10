package com.social_media.social_media.integration;

import com.social_media.social_media.repository.follow.FollowRepositoryImpl;
import com.social_media.social_media.repository.post.PostRepositoryImpl;
import com.social_media.social_media.TestUtils;
import static org.hamcrest.Matchers.is;

import com.social_media.social_media.utils.MessagesExceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class I0009 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepositoryImpl postRepository;

    @Autowired
    private FollowRepositoryImpl followRepository;

    @Test
    @DisplayName("I0009 - Should return 404 when user is not found")
    void testUserNotFound() throws Exception {
        Long nonExistentUserId = 999L;

        mockMvc.perform(get("/products/followed/{userId}/list", nonExistentUserId)
                .param("order", "date_asc")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is(MessagesExceptions.USER_NOT_FOUND)));
    }

    @Test
    @DisplayName("I0009 - Should sort posts by date in descending order")
    void testshouldSortByDateDescending() throws Exception {
        Long followUserId = 2L;
        Long followerUserId = 5L;
        postRepository.add(TestUtils.createRecentPost(followUserId));
        postRepository.add(TestUtils.createRecentPost(followUserId));
        postRepository.add(TestUtils.createRecentPost(followUserId));

        mockMvc.perform(get("/products/followed/{userId}/list", followerUserId)
                .param("order", "date_desc")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts", hasSize(3)))
                .andExpect(jsonPath("$.posts[0].date").isNotEmpty())
                .andExpect(jsonPath("$.posts[1].date").isNotEmpty())
                .andExpect(jsonPath("$.posts[2].date").isNotEmpty());
    }

    @Test
    @DisplayName("I0009 - Should sort posts by date in ascending order")
    void testshouldSortByDateAscending() throws Exception {

        Long followUserId = 16L;
        Long followerUserId = 17L;

        followRepository.addFollow(followerUserId, followUserId);

        postRepository.add(TestUtils.createRecentPost(followUserId));
        postRepository.add(TestUtils.createRecentPost(followUserId));
        postRepository.add(TestUtils.createRecentPost(followUserId));

        mockMvc.perform(get("/products/followed/{userId}/list", followerUserId)
                .param("order", "date_asc")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts", hasSize(3)))
                .andExpect(jsonPath("$.posts[0].date").isNotEmpty())
                .andExpect(jsonPath("$.posts[1].date").isNotEmpty())
                .andExpect(jsonPath("$.posts[2].date").isNotEmpty());

    }

}