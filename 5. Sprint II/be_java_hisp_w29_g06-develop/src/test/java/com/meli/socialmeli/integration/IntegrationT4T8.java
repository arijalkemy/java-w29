package com.meli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.socialmeli.constants.Endpoints;
import com.meli.socialmeli.constants.Messages;
import com.meli.socialmeli.dto.FollowedListResponseDto;
import com.meli.socialmeli.dto.FollowersDto;
import com.meli.socialmeli.repository.UserRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationT4T8 {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("T-004: Test followed list")
    public void testFollowersList() throws Exception {
        String baseUrl = Endpoints.BASE_USERS +  Endpoints.USERS_FOLLOWED_LIST;

        mockMvc.perform(get(baseUrl.replace(
                        "{userId}",
                        "1"
                )))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    FollowedListResponseDto response = new ObjectMapper().readValue(
                            result.getResponse().getContentAsString(),
                            FollowedListResponseDto.class
                    );
                    assert response.getFollowed().size() == 2;
                });

        mockMvc.perform(get(baseUrl.replace(
                        "{userId}",
                        "19"
                ))).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(Messages.USER_NOT_FOUND.replace("%s", "19")));

        mockMvc.perform(get(baseUrl.replace(
                        "{userId}",
                        "4"
                ))).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(Messages.USER_WITHOUT_FOLLOWED));
    }

    @Test
    @DisplayName("T-008: Order Followers")
    void testOrderFollowers() throws Exception {
        String baseUrl = Endpoints.BASE_USERS +  Endpoints.USERS_FOLLOWERS_LIST;

        mockMvc.perform(get(baseUrl.replace(
                        "{userId}",
                        "1"
                ) + "?order=name_asc"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    FollowersDto response = new ObjectMapper().readValue(
                            result.getResponse().getContentAsString(),
                            FollowersDto.class
                    );
                    assert response.getFollowers().get(0).getUser_name().equals("Juanito");
                    assert response.getFollowers().get(1).getUser_name().equals("Pepito");
                });

        mockMvc.perform(get(baseUrl.replace(
                        "{userId}",
                        "1"
                ) + "?order=name_desc"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    FollowersDto response = new ObjectMapper().readValue(
                            result.getResponse().getContentAsString(),
                            FollowersDto.class
                    );
                    assert response.getFollowers().get(0).getUser_name().equals("Pepito");
                    assert response.getFollowers().get(1).getUser_name().equals("Juanito");
                });

        mockMvc.perform(get(baseUrl.replace(
                        "{userId}",
                        "1"
                ) + "?order=invalid_order"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(Messages.ORDER_NOT_FOUND));
    }
}
