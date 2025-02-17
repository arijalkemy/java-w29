package com.social_media.social_media.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static com.social_media.social_media.utils.MessagesExceptions.USER_NOT_FOUND;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.repository.follow.FollowRepositoryImpl;
import com.social_media.social_media.repository.post.PostRepositoryImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class I0006 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepositoryImpl postRepository;

    @Autowired
    private FollowRepositoryImpl followRepository;

    @Test
    @DisplayName("I-0006 Get post for last two weeks Ok ")
    void testGetPostForLastTwoWeeks() throws Exception {

        Post recentPostOne = TestUtils.createRandomPost(13L);
        Post recentPostTwo = TestUtils.createRandomPost(13L);
        Post oldPost = TestUtils.createRandomOldPost(13L);

        postRepository.add(recentPostOne);
        postRepository.add(recentPostTwo);
        postRepository.add(oldPost);

        followRepository.addFollow(10L, 13L);

        mockMvc.perform(get("/products/followed/10/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(10))
                .andExpect(jsonPath("$.posts.length()").value(2));
    }

    @Test
    @DisplayName("I-0006 Get post for last two 404 ")
    void testGetPostForLastTwoWeeksNotFound() throws Exception {

        mockMvc.perform(get("/products/followed/999/list"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is(USER_NOT_FOUND)));
    }
}
