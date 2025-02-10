package com.socialmeli.socialmeli.controllers;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.utils.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Comparator;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmeli.socialmeli.enums.Message;
import com.socialmeli.socialmeli.utils.PostFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @ValueSource(strings = {"/products/post", "/products/promo-post"})
    @DisplayName("#21 savePost - should return 200 OK when product does not exist and user is not seller")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void savePost_whenProductDoesNotExistAndUserIsNotSeller_thenSavePost(String url) throws Exception {
        // Arrange
        Object post;

        if (url.equals("/products/post")) {
            post = PostFactory.createPostDto(2, 1);
        } else {
            post = PostFactory.createPostSaleDto(2, 1);
        }

        String message = Message.POST_PUBLISHED.getStr();

        // Act & Assert
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(message));
    }

    @ParameterizedTest
    @ValueSource(strings = {"/products/post", "/products/promo-post"})
    @DisplayName("#22 savePost - should return 200 when product does not exist and user is seller")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void savePost_whenProductDoesNotExistAndUserIsSeller_thenSavePost(String url) throws Exception {
        // Arrange
        Object post;

        if (url.equals("/products/post")) {
            post = PostFactory.createPostDto(1, 1);
        } else {
            post = PostFactory.createPostSaleDto(1, 1);
        }

        String message = Message.POST_PUBLISHED.getStr();

        // Act & Assert
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(message));
    }

    @ParameterizedTest
    @ValueSource(strings = {"/products/post", "/products/promo-post"})
    @DisplayName("#23 savePost - should return 409 when product already exists")
    void savePost_whenProductAlreadyExists_thenReturn400(String url) throws Exception {
        // Arrange
        Object post;

        if (url.equals("/products/post")) {
            post = PostFactory.createPostDto(1, 201);
        } else {
            post = PostFactory.createPostSaleDto(1, 201);
        }

        String message = Message.PRODUCT_ALREADY_EXISTS.getStr();

        // Act & Assert
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value(message));
    }

    @ParameterizedTest
    @ValueSource(strings = {"/products/post", "/products/promo-post"})
    @DisplayName("#24 savePost - should return 400 when User Id is invalid")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void savePost_whenUserIdIsInvalid_thenThrow400(String url) throws Exception {
        // Arrange
        Object post;

        if (url.equals("/products/post")) {
            post = PostFactory.createPostDto(-1, 1);
        } else {
            post = PostFactory.createPostSaleDto(-1, 1);
        }

        String message = Message.POST_PUBLISHED.getStr();

        // Act & Assert
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(strings = {"/products/post", "/products/promo-post"})
    @DisplayName("#25 savePost - should return 400 when no body is received")
    void savePost_whenNoBodyReceived_thenReturn400(String url) throws Exception {
        // Act & Assert
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    // US-0006: Obtener un listado de las publicaciones realizadas por los vendedores
    // que un usuario sigue en las últimas dos semanas.
    @ParameterizedTest
    @CsvSource({"date_asc", "date_desc", "DEFAULT"})
    @DisplayName("#26 getPostsOfFollowedSellers by date")
    public void getPostsOfFollowedSellersTest_whenOrderByDateAscOrDesc_thenReturnAList(String order) throws Exception {
        // Arrange
        User user = UserFactory.createBuyer(2);
        List<PostDto> postsExpected = List.of(
                PostFactory.createPostIdDateDto(4, LocalDate.of(2025, 1, 25)),
                PostFactory.createPostIdDateDto(5, LocalDate.of(2025, 1, 27)),
                PostFactory.createPostIdDateDto(3, LocalDate.of(2025, 1, 30)),
                PostFactory.createPostIdDateDto(2, LocalDate.of(2025, 1, 31)),
                PostFactory.createPostIdDateDto(1, LocalDate.of(2025, 2, 2))
        );

        if ("date_desc".equals(order) || "DEFAULT".equals(order)) {
            postsExpected = postsExpected.stream()
                    .sorted(Comparator.comparing(PostDto::getDate).reversed())
                    .toList();
        }

        // Act & Assert
        ResultActions result = mockMvc.perform(get("/products/followed/{userId}/list", user.getId())
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(user.getId()))
                .andExpect(jsonPath("$.posts").isArray())
                .andExpect(jsonPath("$.posts.length()").value(postsExpected.size()));

        for (int i = 0; i < postsExpected.size(); i++) {
            Integer expectedId = postsExpected.get(i).getUserId();
            String expectedDate = postsExpected.get(i).getDate().toString();
            result.andExpect(jsonPath("$.posts[" + i + "].post_id").value(expectedId))
                    .andExpect(jsonPath("$.posts[" + i + "].date").value(expectedDate));
        }
    }

    @Test
    @DisplayName("#27 getPostsOfFollowedSellers - should return 404 when userid is not a number")
    public void getPostsOfFollowedSellersTest_whenUserIdIsNotANumber_thenThrow404() throws Exception {
        // Arrange
        String order = "date_asc";
        String userId = "numero";
        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("#28 getPostsOfFollowedSellers - should return 400 when order does not match")
    public void getPostsOfFollowedSellersTest_whenOrderDoesntMatch_thenThrow400() throws Exception {
        // Arrange
        String order = "word";
        User user = UserFactory.createBuyer(2);

        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", user.getId())
                        .param("order", order))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("#29 getPostsOfFollowedSellers - should return 400 when user id is negative")
    public void getPostsOfFollowedSellersTest_whenUserIdIsInvalid_thenThrow400() throws Exception {
        // Arrange
        String order = "date_asc";
        Integer userIdNegative = -1;

        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userIdNegative)
                        .param("order", order))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("#30 getPostsOfFollowedSellers - should return 404 when user is not found")
    public void getPostsOfFollowedSellersTest_whenUserIsNotFound_thenThrow404() throws Exception {
        // Arrange
        String order = "date_asc";
        Integer userId = 999;
        String message = Message.USER_NOT_FOUND.format(userId);

        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message));
    }

    // US 0011 - Obtener la cantidad de productos en promoción de un determinado vendedor.
    @Test
    @DisplayName("#38 Get the number of promotional products for a specific seller")
    void getPromoPostCountTest() throws Exception {

        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", "5"))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.promo_products_count").value(1))
                .andExpect(jsonPath("$.user_name").value("Franca Pairetti"));
    }

    @Test
    @DisplayName("#39 NotFoundException")
    void getPromoPostCountTest_whenUserNotFound_thenThrow404() throws Exception {

        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", "203"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("#40 UserIsNotSeller")
    void getPromoPostCountTest_whenUserIsNotSeller_thenThrow() throws Exception {

        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", "4"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("#41 Invalid user id")
    void getPromoPostCountTest_when() throws Exception {

        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", "-5"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("#42 Empty List")
    void getPromoPostCountTest_whenListIsEmpty_thenThrow() throws Exception {

        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", "7"))
                .andExpect(status().isNotFound());
    }
}
