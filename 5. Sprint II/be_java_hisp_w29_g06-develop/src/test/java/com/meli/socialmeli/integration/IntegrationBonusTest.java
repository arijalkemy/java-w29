package com.meli.socialmeli.integration;


import com.meli.socialmeli.constants.Endpoints;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationBonusTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("TI-0013: Create new User")
    void createUserTest() throws Exception {
        mockMvc.perform(post(Endpoints.BASE_USERS)
                .contentType("application/json")
                .content("{\"user_name\": \"Juan\"}"))
                .andExpect(status().isCreated())
                .andReturn();

        mockMvc.perform(post(Endpoints.BASE_USERS)
                        .contentType("application/json")
                        .content("{\"user_name\": \"\"}"))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("TI-0014: Create new Seller")
    void createSellerTest() throws Exception {
        mockMvc.perform(post(Endpoints.BASE_SELLER)
                .contentType("application/json")
                .content("{\"user_name\": \"Juan Vendedor\"}"))
                .andExpect(status().isCreated())
                .andReturn();

        mockMvc.perform(post(Endpoints.BASE_SELLER)
                        .contentType("application/json")
                        .content("{\"user_name\": \"\"}"))
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("TI-0015: Filter posts by price")
    void filterPostsByPriceTest() throws Exception {
        String baseUrl = Endpoints.BASE_POSTS + Endpoints.POSTS_FILTER_BY_PRICE;
        mockMvc.perform(get(baseUrl+"?minPrice=500"))
                .andExpect(status().isOk());
        mockMvc.perform(get(baseUrl+"?maxPrice=2000"))
                .andExpect(status().isOk());
        mockMvc.perform(get(baseUrl+"?minPrice=500&maxPrice=2000"))
                .andExpect(status().isOk());
        mockMvc.perform(get(baseUrl+"?maxPrice=0"))
                .andExpect(status().isNotFound());
    }
}
