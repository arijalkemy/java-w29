package com.social_media.social_media.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static com.social_media.social_media.utils.MessagesExceptions.POST_NOT_FOUND;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.repository.post.PostRepositoryImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class I0014 {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PostRepositoryImpl postRepository;

    @Test
    @DisplayName("I-0014 create stock Ok ")
    void testCreateStock() throws Exception {
        String requestBody = """
                    {
                        "units":10
                    }
                """;

        Post post = TestUtils.createRandomPost(1L);

        postRepository.add(post);

        mockMvc.perform(post("/stock/" + post.getPostId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.units").value(10));

        mockMvc.perform(get("/products/post/" + post.getPostId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stock.units").value(10));
    }

    @Test
    @DisplayName("I-0014 Create stock 404 ")
    void testCreateStockNotFound() throws Exception {

        String requestBody = """
                    {
                        "units":10
                    }
                """;

        mockMvc.perform(post("/stock/99999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is(POST_NOT_FOUND)));
    }
}
