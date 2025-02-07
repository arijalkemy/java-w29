package com.thiagoschreck.local.melisocial.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thiagoschreck.local.melisocial.dto.request.CreateUserRequestDTO;
import com.thiagoschreck.local.melisocial.dto.response.CreateUserResponseDTO;
import com.thiagoschreck.local.melisocial.dto.response.ErrorResponse;
import com.thiagoschreck.local.melisocial.dto.response.user.ClientDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerFollowersCountDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.UserInfoDTO;
import com.thiagoschreck.local.melisocial.entity.user.Client;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import com.thiagoschreck.local.melisocial.repository.UsersRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UsersControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UsersRepositoryImpl repository;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @BeforeEach
    void beforeEach() {
        repository.resetDb();
    }

    @Test
    @DisplayName("Given user sends valid information When client unfollows seller Then they are removed from their lists")
    void testSuccessfulUnfollow() throws Exception {
        // ARRANGE
        Client client = new Client("Client");
        Seller seller = new Seller("Seller");
        client.getFollowing().add(seller);
        seller.getFollowers().add(client);

        int clientId = repository.save(client).getUserId();
        int sellerId = repository.save(seller).getUserId();
        // ACT
        // ASSERT
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", clientId, sellerId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(clientId))
                .andExpect(jsonPath("$.user_name").value("Client"))
                .andExpect(jsonPath("$.followed").isEmpty());
    }

    @Test
    @DisplayName("Given client doesnt follow seller When client unfollows seller Then UserNotFollowingSellerException is thrown")
    void testUnfollowAlreadyNotFollowing() throws Exception{
        // ARRANGE
        Client client = new Client("Client");
        Seller seller = new Seller("Seller");

        int clientId = repository.save(client).getUserId();
        int sellerId = repository.save(seller).getUserId();
        // ACT
        // ASSERT
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", clientId, sellerId))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(String.format("User %d is not following seller %d", clientId, sellerId)));
    }

    @Test
    @DisplayName("Given client id doesnt exist When client unfollows seller Then ClientNotFoundException is thrown")
    void testUnfollowClientNotFound() throws Exception {
        // ARRANGE
        // ACT
        // ASSERT
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 0, 0))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Client not found!"));
    }

    @Test
    @DisplayName("Given seller id doesnt exist When client unfollows seller Then SellerNotFoundException is thrown")
    void testUnfollowSellerNotFound() throws Exception {
        // ARRANGE
        Client client = new Client("Client");

        int clientId = repository.save(client).getUserId();
        int sellerId = 2;
        // ACT
        // ASSERT
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", clientId, sellerId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(String.format("Could not find seller with ID %d", sellerId)));
    }

    @Test
    void testCreateClient() throws Exception {
        CreateUserRequestDTO createUserRequest = new CreateUserRequestDTO("Johnny Test");
        MvcResult createClientMvcResult = mockMvc.perform(post("/users/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writeValueAsString(createUserRequest)))
                .andExpect(status().isOk())
                .andReturn();

        CreateUserResponseDTO createUserResponse = map(createClientMvcResult, CreateUserResponseDTO.class);

        assertNotNull(createUserResponse);
        assertNotNull(createUserResponse.userId());
        assertEquals(formatUsername(createUserRequest.userName()), createUserResponse.userName());
    }

    @Test
    void testCreateClientEmptyBody() throws Exception {
        mockMvc.perform(post("/users/clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCreateSeller() throws Exception {
        CreateUserRequestDTO createUserRequest = new CreateUserRequestDTO("Johnny Test");
        MvcResult createSellerMvcResult = mockMvc.perform(post("/users/sellers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writeValueAsString(createUserRequest)))
                .andExpect(status().isOk())
                .andReturn();

        CreateUserResponseDTO createUserResponse = map(createSellerMvcResult, CreateUserResponseDTO.class);

        assertNotNull(createUserResponse);
        assertNotNull(createUserResponse.userId());
        assertEquals(formatUsername(createUserRequest.userName()), createUserResponse.userName());
    }

    @Test
    void testCreateSellerEmptyBody() throws Exception {
        mockMvc.perform(post("/users/sellers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testGetSellerFollowers() throws Exception {
        //ARRANGE
        Seller seller = new Seller("Seller");
        Client client1 = new Client("Client 1");
        Client client2 = new Client("Client 2");
        int sellerId = repository.save(seller).getUserId();
        repository.save(client1);
        repository.save(client2);
        seller.addFollower(client1);
        seller.addFollower(client2);

        SellerDTO expected = new SellerDTO(
                seller.getUserId(),
                seller.getUserName(),
                List.of(
                        new UserInfoDTO(client1.getUserId(), client1.getUserName()),
                        new UserInfoDTO(client2.getUserId(), client2.getUserName())
                )
        );

        //ACT
        //ASSERT
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        SellerDTO responseDTO = map(responseBody, SellerDTO.class);

        assertEquals(expected, responseDTO);
    }

    @Test
    void testGetSellerFollowersWhenSellerNotFound() throws Exception {
        //ARRANGE
        int sellerId = 1;
        ErrorResponse expected = new ErrorResponse(
                String.format("Could not find seller with ID %d", sellerId)
        );
        //ACT
        //ASSERT
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(404))
                .andReturn().getResponse().getContentAsString();
        ErrorResponse responseDTO = map(responseBody, ErrorResponse.class);
        assertEquals(expected, responseDTO);
    }

    @Test
    public void testGetSellerFollowersInvalidOrder() throws Exception {
        //ARRANGE
        int sellerId = 1;
        ErrorResponse expected = new ErrorResponse("The specified sort order is invalid. Please provide a valid order (e.g., 'name_asc' or 'name_desc').");
        //ACT
        //ASSERT
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list?order=invalid_order", sellerId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andReturn().getResponse().getContentAsString();
        ErrorResponse responseDTO = map(responseBody, ErrorResponse.class);

        assertEquals(expected, responseDTO);
    }


    @Test
    public void getClientFollowedSellersOrderAsc() throws Exception {
        //ARRANGE
        Client client = new Client("Client");
        Seller seller1 = new Seller("Seller 1");
        Seller seller2 = new Seller("Seller 2");
        int sellerId = repository.save(client).getUserId();
        repository.save(seller1);
        repository.save(seller2);
        client.followSeller(seller1);
        client.followSeller(seller2);

        ClientDTO expected = new ClientDTO(
                client.getUserId(),
                client.getUserName(),
                List.of(
                        new UserInfoDTO(seller1.getUserId(), seller1.getUserName()),
                        new UserInfoDTO(seller2.getUserId(), seller2.getUserName())
                )
        );

        //ACT
        //ASSERT
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=name_asc", sellerId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        ClientDTO responseDTO = map(responseBody, ClientDTO.class);

        assertEquals(expected, responseDTO);
    }

    @Test
    public void getClientFollowedSellersOrderDesc() throws Exception {
        //ARRANGE
        Client client = new Client("Client");
        Seller seller1 = new Seller("Seller 1");
        Seller seller2 = new Seller("Seller 2");
        int sellerId = repository.save(client).getUserId();
        repository.save(seller1);
        repository.save(seller2);
        client.followSeller(seller1);
        client.followSeller(seller2);

        ClientDTO expected = new ClientDTO(
                client.getUserId(),
                client.getUserName(),
                List.of(
                        new UserInfoDTO(seller2.getUserId(), seller2.getUserName()),
                        new UserInfoDTO(seller1.getUserId(), seller1.getUserName())
                )
        );

        //ACT
        //ASSERT
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list?order=name_desc", sellerId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        ClientDTO responseDTO = map(responseBody, ClientDTO.class);

        assertEquals(expected, responseDTO);
    }


    private String formatUsername(String rawUsername) {
        return rawUsername.trim().replace(" ", "_");
    }

    private <T> T map(Object object, Class<T> clazz) throws IOException {
        return new ObjectMapper().readValue(String.valueOf(object), clazz);
    }

    private <T> T map(MvcResult mvcResult, Class<T> clazz) {
        return Optional.ofNullable(mvcResult)
                .map(MvcResult::getResponse)
                .map(MockHttpServletResponse::getContentAsByteArray)
                .map(content -> map(content, clazz))
                .orElse(null);
    }

    private String writeValueAsString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    private <T> T map(byte[] byteArray, Class<T> clazz) {
        try {
            return objectMapper.readValue(byteArray, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testFollowSeller() throws Exception {
        // ARRANGE
        Client client = new Client("Client");
        Seller seller = new Seller("Seller");

        int clientId = repository.save(client).getUserId();
        int sellerId = repository.save(seller).getUserId();
        // ACT/ASSERT
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", clientId, sellerId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(clientId))
                .andExpect(jsonPath("$.user_name").value(client.getUserName()))
                .andExpect(jsonPath("$.followed[0].user_id").value(sellerId));
    }

    @Test
    void testAlreadyFollowingSeller() throws Exception {
        Client client = new Client("Client");
        Seller seller = new Seller("Seller");
        client.getFollowing().add(seller);
        seller.getFollowers().add(client);
        int clientId = repository.save(client).getUserId();
        int sellerId = repository.save(seller).getUserId();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", clientId, sellerId))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(String.format("User %d is following seller %d", clientId, sellerId)));
    }

    @Test
    void testGetSellerFollowersCount() throws Exception {
        //Arrange
        Seller seller = new Seller("Seller");
        int sellerId = repository.save(seller).getUserId();

        Client client1 = new Client("Client 1");
        Client client2 = new Client("Client 2");

        repository.save(client1);
        repository.save(client2);

        seller.addFollower(client1);
        seller.addFollower(client2);
        SellerFollowersCountDTO expected = new SellerFollowersCountDTO(
                seller.getUserId(),
                seller.getUserName(),
                seller.getFollowers().size()
        );
        //Act
        //Assert
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", sellerId))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        SellerFollowersCountDTO responseDTO = map(responseBody, SellerFollowersCountDTO.class);

        assertEquals(expected, responseDTO);
    }
}
