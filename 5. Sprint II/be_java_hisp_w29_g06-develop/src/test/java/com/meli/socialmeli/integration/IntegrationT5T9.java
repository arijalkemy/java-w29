package com.meli.socialmeli.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.socialmeli.constants.Endpoints;
import com.meli.socialmeli.constants.Messages;
import com.meli.socialmeli.dto.PostDto;
import com.meli.socialmeli.dto.ProductDto;
import com.meli.socialmeli.dto.response.PostFromFollowedDto;
import com.meli.socialmeli.entity.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationT5T9 {

    @Autowired
    private MockMvc mockMvc;

    private static final Integer USER_ID = 1;
    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Test
    public void addPost() throws Exception {
        ProductDto productDto = createProductDto();
        PostDto post = createPostDto(productDto);

        String payloadJson = mapper.writeValueAsString(post);

        this.mockMvc.perform(post(Endpoints.BASE_POSTS + Endpoints.POSTS_POST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value(Messages.SUCCESS));
    }

    @Test
    public void getPostsFromFollowedUsers() throws Exception {
        MvcResult response = this.mockMvc
                .perform(get(Endpoints.BASE_POSTS + Endpoints.POSTS_FOLLOWED_LIST, USER_ID)
                        .param("order", "date_asc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(USER_ID))
                .andReturn();

        PostFromFollowedDto postFromFollowedDto = mapper.readValue(response.getResponse().getContentAsString(),
                new TypeReference<PostFromFollowedDto>() {});

        List<PostDto> posts = postFromFollowedDto.getPosts();

        assertTrue(isSortedByDate(posts));
    }

    private boolean isSortedByDate(List<PostDto> posts) {
        for (int i = 1; i < posts.size(); i++) {
            if (posts.get(i).getDate().isBefore(posts.get(i - 1).getDate())) {
                return false;
            }
        }
        return true;
    }

    private ProductDto createProductDto() {
        return ProductDto.builder()
                    .productId(7)
                    .productName("Altavozz")
                    .type("Audio")
                    .brand("SoundBlast")
                    .color("Rojo")
                    .notes("Altavoz portatil con Bluetooth")
                    .build();
    }

    private PostDto createPostDto(ProductDto productDto) {
        return PostDto.builder()
                    .id(12)
                    .date(LocalDate.now())
                    .price(200.0)
                    .product(productDto)
                    .userId(USER_ID)
                    .discount(0.0)
                    .hasPromo(false)
                    .category(200)
                    .build();
    }

}