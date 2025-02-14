package com.meli.socialmeli.integration;

import com.meli.socialmeli.constants.Messages;
import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;
import com.meli.socialmeli.repository.SellerRepositoryImpl;
import com.meli.socialmeli.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationT1T6 {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private SellerRepositoryImpl sellerRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void beforeEach() {
        User user = new User(15, "Pepito", new ArrayList<>());

        this.userRepository.save(user);

        Seller seller = new Seller(15, "Juanito", new ArrayList<>());

        this.sellerRepository.save(seller);
    }

    @Test
    public void testT1() throws Exception {
        mockMvc.perform(post("/users/15/follow/15"))
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.message").value(Messages.SUCCESS_FOLLOW));

        mockMvc.perform(post("/users/15/follow/15"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value(Messages.USER_ALREADY_FOLLOWED));
    }

    @Test
    public void testT6() throws Exception {
        mockMvc.perform(get("/products/followed/1/list"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(Messages.ORDER_NOT_FOUND));

        mockMvc.perform(get("/products/followed/1/list?order=name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts").isArray())
                .andExpect(jsonPath("$.user_id").value(1));
    }

}
