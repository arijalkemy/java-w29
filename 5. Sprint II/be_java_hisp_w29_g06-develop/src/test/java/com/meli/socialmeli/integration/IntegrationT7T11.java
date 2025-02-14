package com.meli.socialmeli.integration;

import com.meli.socialmeli.constants.Messages;
import com.meli.socialmeli.entity.Post;
import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;
import com.meli.socialmeli.repository.PostRepositoryImpl;
import com.meli.socialmeli.repository.SellerRepositoryImpl;
import com.meli.socialmeli.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationT7T11 {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private SellerRepositoryImpl sellerRepository;


    @Autowired
    private MockMvc mockMvc;

    private User user;
    private Seller seller;

    @BeforeEach
    public void beforeEach() {
        user = new User(20, "Pepito", new ArrayList<>());
        seller = new Seller(20, "VendedorX", new ArrayList<>());
        this.userRepository.save(user);
        this.sellerRepository.save(seller);
        sellerRepository.addFollower(seller, user);

    }

    @Test
    public void testUnfollowSellerSuccess() throws Exception {
        mockMvc.perform(post("/users/20/unfollow/20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(Messages.SUCCESS_UNFOLLOW));

        mockMvc.perform(post("/users/20/unfollow/20"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(Messages.USER_NOT_FOLLOWING_SELLER));
    }

    @Test
    public void testGetNumberOfProductsInSaleSuccess() throws Exception {

        mockMvc.perform(get("/products/promo-post/count?user_id=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Don German"))
                .andExpect(jsonPath("$.promo_products_count").value(5L));
    }

}