package com.social_media.social_media.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.social_media.social_media.utils.MessagesExceptions.FOLLOWED_USER_NOT_SELLER;
import static com.social_media.social_media.utils.MessagesExceptions.SELLER_ID_NOT_EXIST;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class I0011 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("I-0011 - Test of search Sellers With Promo Posts - OK")
    void searchSellersWithPromoPosts() throws Exception {

        Long userId = 1L;
        this.mockMvc.perform(get("/products/promo-post/count")
                .param("userId", String.valueOf(userId)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("I-0011 - Test of search Sellers With Promo Posts - 404 (Seller not exist)")
    void searchSellersWithPromoPostsNotExistSeller() throws Exception {

        Long userId = 1000L;
        this.mockMvc.perform(get("/products/promo-post/count")
                .param("userId", String.valueOf(userId)))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(SELLER_ID_NOT_EXIST));
    }

    @Test
    @DisplayName("I-0011 - Test of search Sellers With Promo Posts - 403 (Followed user not seller)")
    void searchSellersWithPromoPostsFollowedUserNotSeller() throws Exception {

        Long userId = 12L;
        this.mockMvc.perform(get("/products/promo-post/count")
                .param("userId", String.valueOf(userId)))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value(FOLLOWED_USER_NOT_SELLER));
    }
}
