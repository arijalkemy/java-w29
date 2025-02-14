package com.meli.socialmeli.integration;

import java.util.ArrayList;
import com.meli.socialmeli.constants.Messages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.repository.SellerRepositoryImpl;
import com.meli.socialmeli.repository.UserRepositoryImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationT2T3 {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private SellerRepositoryImpl sellerRepository;

    @Autowired
    private MockMvc mockMvc;

    private Integer idInvalid;
    private String expectedUserName;
    private Integer expectedUserId;

    @BeforeEach
    public void beforeEach() {
        idInvalid = 0;
        expectedUserName = "Don German";
        expectedUserId = 1;
    }

    @Test
    @DisplayName("TI-0002: Integration Test for US-0002")
    public void integrationTestT2() throws Exception {
        //Arrange
        Integer expectedFollowersCount = 2;
        //Act & Assert
        // Verificar si el vendedor con ese id existe, si no devuelve estado y mensaje not found
        mockMvc.perform(get("/users/{userId}/followers/count".replace("{userId}", idInvalid.toString())))
               .andExpect(status().isNotFound())
               .andExpect(jsonPath("$.message").value(Messages.SELLER_NOT_FOUND.replace("%s", idInvalid.toString())));
        // Verificar que el vendedor con ese id existe y devuelve estado OK y mensaje con la cantidad de seguidores
        mockMvc.perform(get("/users/{userId}/followers/count".replace("{userId}", expectedUserId.toString())))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.user_id").value(expectedUserId))
               .andExpect(jsonPath("$.user_name").value(expectedUserName))
               .andExpect(jsonPath("$.followers_count").value(expectedFollowersCount));
    }

    @Test
    @DisplayName("TI-0003: Integration Test for US-0003")
    public void integrationTestT3() throws Exception {
        //Arrange
        Integer sellerIdWithNoFollows = 4;
        //Act & Assert
        // Verificar si el vendedor con ese id existe, si no devuelve estado y mensaje not found
        mockMvc.perform(get("/users/{userId}/followers/list".replace("{userId}", idInvalid.toString())))
               .andExpect(status().isNotFound())
               .andExpect(jsonPath("$.message").value(Messages.SELLER_NOT_FOUND.replace("%s", idInvalid.toString())));
        // Verificar si el vendedor con ese id existe, si si pero no tiene seguidores devuelve estado y mensaje not found
        mockMvc.perform(get("/users/{userId}/followers/list".replace("{userId}", sellerIdWithNoFollows.toString())))
               .andExpect(status().isNotFound())
               .andExpect(jsonPath("$.message").value(Messages.NO_FOLLOWERS_ASSOCIATED));
        // Verificar que el vendedor con ese id existe y devuelve estado OK y mensaje con la lista de seguidores no vacia
        mockMvc.perform(get("/users/{userId}/followers/list".replace("{userId}", expectedUserId.toString())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(expectedUserId))
                .andExpect(jsonPath("$.user_name").value(expectedUserName))
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers").isNotEmpty());
     }
}
