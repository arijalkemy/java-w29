package com.socialmeli.socialmeli.controllers;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.utils.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    // US 0005 - Dar de alta una nueva publicación.
    // US 0010 - Llevar a cabo la publicación de un nuevo producto en promoción.
    @ParameterizedTest
    @ValueSource(strings = {"/products/post", "/products/promo-post"})
    @DisplayName("#22 savePost - should return 200 OK when product does not exist and user is not seller")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void savePost_whenProductDoesNotExistAndUserIsNotSeller_thenSavePost(String url) throws Exception {
        // Arrange
        Object post = PostFactory.createPostDto(2, 1, Objects.equals(url, "/products/promo-post"));

        String message = "Post published successfully";

        // Act & Assert
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(message));
    }

    @ParameterizedTest
    @ValueSource(strings = {"/products/post", "/products/promo-post"})
    @DisplayName("#23 savePost - should return 200 when product does not exist and user is seller")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void savePost_whenProductDoesNotExistAndUserIsSeller_thenSavePost(String url) throws Exception {
        // Arrange
        Object post = PostFactory.createPostDto(1, 1, Objects.equals(url, "/products/promo-post"));

        String message = "Post published successfully";

        // Act & Assert
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(message));
    }

    @ParameterizedTest
    @ValueSource(strings = {"/products/post", "/products/promo-post"})
    @DisplayName("#24 savePost - should return 409 when product already exists")
    void savePost_whenProductAlreadyExists_thenReturn400(String url) throws Exception {
        // Arrange
        Object post = PostFactory.createPostDto(1, 201, Objects.equals(url, "/products/promo-post"));

        String message = "A post with this product already exists";

        // Act & Assert
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value(message));
    }

    @ParameterizedTest
    @ValueSource(strings = {"/products/post", "/products/promo-post"})
    @DisplayName("#25 savePost - should return 400 when User Id is invalid")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void savePost_whenUserIdIsInvalid_thenThrow400(String url) throws Exception {
        // Arrange
        Object post = PostFactory.createPostDto(-1, 1, Objects.equals(url, "/products/promo-post"));

        // Act & Assert
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(strings = {"/products/post", "/products/promo-post"})
    @DisplayName("#26 savePost - should return 400 when no body is received")
    void savePost_whenNoBodyReceived_thenReturn400(String url) throws Exception {
        // Act & Assert
        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    // US-0006: Obtener un listado de las publicaciones realizadas por los vendedores
    // que un usuario sigue en las últimas dos semanas.
    @ParameterizedTest
    @ValueSource(strings = {"date_desc", "DEFAULT"})
    @DisplayName("#26 getPostsOfFollowedSellers - successful (date_desc or DEFAULT)")
    public void getPostsOfFollowedSellersTest_whenOrderByDateDescOrDefault_thenReturnAList(String order)
            throws Exception {
        // Arrange
        User user = UserFactory.createBuyer(2);
        List<PostDto> postsExpected = PostFactory.createListPostDtoForUser2Desc();

        // Act & Assert
        ResultActions result = mockMvc.perform(get("/products/followed/{userId}/list", user.getId())
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(user.getId()))
                .andExpect(jsonPath("$.posts").isArray())
                .andExpect(jsonPath("$.posts.length()").value(postsExpected.size()));

        for (int i = 0; i < postsExpected.size(); i++) {
            String expectedDate = postsExpected.get(i).getDate().toString();
            result.andExpect(jsonPath("$.posts[" + i + "].date").value(expectedDate));
        }
    }

    // US-0006: Obtener un listado de las publicaciones realizadas por los vendedores
    // que un usuario sigue en las últimas dos semanas.
    @Test
    @DisplayName("#26 getPostsOfFollowedSellers - successful (date_asc)")
    public void getPostsOfFollowedSellersTest_whenOrderByDateAsc_thenReturnAList() throws Exception {
        // Arrange
        String order = "date_asc";
        User user = UserFactory.createBuyer(2);
        List<PostDto> postsExpected = PostFactory.createListPostDtoForUser2Asc();

        // Act & Assert
        ResultActions result = mockMvc.perform(get("/products/followed/{userId}/list", user.getId())
                        .param("order", order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(user.getId()))
                .andExpect(jsonPath("$.posts").isArray())
                .andExpect(jsonPath("$.posts.length()").value(postsExpected.size()));

        for (int i = 0; i < postsExpected.size(); i++) {
            String expectedDate = postsExpected.get(i).getDate().toString();
            result.andExpect(jsonPath("$.posts[" + i + "].date").value(expectedDate));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"date_asc", "date_desc", "DEFAULT"})
    @DisplayName("#28 getPostsOfFollowedSellers - should return 404 when userid is not a number")
    public void getPostsOfFollowedSellersTest_whenUserIdIsNotANumber_thenThrow400(String order) throws Exception {
        // Arrange
        String userId = "numero";

        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("#29 getPostsOfFollowedSellers - should return 400 when order does not match")
    public void getPostsOfFollowedSellersTest_whenOrderDoesntMatch_thenThrow400() throws Exception {
        // Arrange
        String order = "word";
        User user = UserFactory.createBuyer(2);

        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", user.getId())
                        .param("order", order))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(strings = {"date_asc", "date_desc", "DEFAULT"})
    @DisplayName("#30 getPostsOfFollowedSellers - should return 400 when user id is negative")
    public void getPostsOfFollowedSellersTest_whenUserIdIsInvalid_thenThrow400(String order) throws Exception {
        // Arrange
        Integer userIdNegative = -1;

        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userIdNegative)
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @ValueSource(strings = {"date_asc", "date_desc", "DEFAULT"})
    @DisplayName("#31 getPostsOfFollowedSellers - should return 404 when user is not found")
    public void getPostsOfFollowedSellersTest_whenUserIsNotFound_thenThrow404(String order) throws Exception {
        // Arrange
        Integer userId = 999;
        String message = "User with ID 999 not found";

        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message));
    }

    // US 0011 - Obtener la cantidad de productos en promoción de un determinado vendedor.
    @Test
    @DisplayName("#39 Get the number of promotional products for a specific seller")
    void getPromoPostCountTest() throws Exception {
        // Arrange
        User user = UserFactory.createSeller(5, "Franca Pairetti");

        // Act & Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", user.getId().toString()))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.promo_products_count").value(1))
                .andExpect(jsonPath("$.user_name").value(user.getName()));
    }

    @Test
    @DisplayName("#40 NotFoundException")
    void getPromoPostCountTest_whenUserNotFound_thenThrow404() throws Exception {
        // Arrange
        String userId = "999";
        String message = "User with ID 999 not found";

        // Act & Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message));
    }

    @Test
    @DisplayName("#41 UserIsNotSeller")
    void getPromoPostCountTest_whenUserIsNotSeller_thenThrow() throws Exception {
        // Arrange
        String userId = "2";
        String message = "Carolina Comba is not a seller";

        // Act & Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", userId))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message));
    }

    @Test
    @DisplayName("#42 Invalid user id")
    void getPromoPostCountTest_when() throws Exception {
        // Arrange
        String userId = "-5";

        // Act & Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", userId))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("#43 Empty List")
    void getPromoPostCountTest_whenListIsEmpty_thenThrow400() throws Exception {
        // Arrange
        String userId = "7";
        String message = "No promotional posts found for Martín Marquez";

        // Act & Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", userId))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message));
    }
}
