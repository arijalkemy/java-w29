package com.app.integration;

import com.app.dto.request.PostDTO;
import com.app.dto.request.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void US_0005() throws Exception {
        int userId = 6000;

        ProductDTO productDTO = new ProductDTO(87, "TV", "Electronics", "LG", "Black", "4K Ultra HD Smart TV with a large screen.");

        PostDTO postDTO = new PostDTO(
                70,
                userId,
                "30-01-2025",
                productDTO,
                1,
                500.0,
                true,
                0.20
        );

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postDTO)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Post was successfully created."));
    }

    @Test
    void US_0006() throws Exception {
        int userId = 6000;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                .param("order", "date_asc"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.posts").isArray())
                .andExpect(jsonPath("$.posts.length()").value(1))
                .andExpect(jsonPath("$.posts[0].post_id").value(6004))
                .andExpect(jsonPath("$.posts[0].user_id").value(6004))
                .andExpect(jsonPath("$.posts[0].product.product_id").value(6))
                .andExpect(jsonPath("$.posts[0].category").value(1))
                .andExpect(jsonPath("$.posts[0].price").value(500.0))
                .andExpect(jsonPath("$.posts[0].date").value("2025-01-30"))
                .andExpect(jsonPath("$.posts[0].has_promo").value(true))
                .andExpect(jsonPath("$.posts[0].discount").value(0.20));
    }

    @Test
    @DisplayName("US 0010 | POST /products/promo-post - Creates a promo post and returns a SuccessDTO.")
    void US_0010_createPromoPost() throws Exception {
        int userId = 6000;

        ProductDTO productDTO = new ProductDTO(88, "TV", "Electronics", "LG", "Black", "4K Ultra HD Smart TV with a large screen.");

        PostDTO postDTO = new PostDTO(
                71,
                userId,
                "30-01-2025",
                productDTO,
                1,
                500.0,
                true,
                0.20
        );

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postDTO)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Promo post was successfully created."));
    }

    @Test
    @DisplayName("US 0011 | GET /products/promo-post/count - retrieves a DTO with the number of promo posts for a user")
    public void getPromoProductsCountByUserId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count")
                        .param("user_id", "11000"))
                .andExpect(status().isOk())
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(11000))
                .andExpect(jsonPath("$.user_name").value("Julian Castro"))
                .andExpect(jsonPath("$.promo_products_count").value(5));
    }

    @Test
    @DisplayName("US 0011 | GET /products/promo-post/count - should throw BadRequestException if the user is not a seller")
    public void getPromoProductsCountByUserId_ShouldThrowBadRequestException_WhenUserIsNotSeller() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count")
                        .param("user_id", "11002"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }



}
