package com.app.integration;

import com.app.util.ResponseMessages;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    // @Autowired
    // private IUserRepository repository;

    // queda de ejemplo
    @Test
    void US_0001_shouldReturnAllUsers() throws Exception {
        mockMvc.perform(get("/users/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].user_name").value("Fernando González"));
    }

    @Test
    @DisplayName("T-0001 - US-0001 - Follow a seller should return a 200 response test")
    void US_0001_followASellerShouldReturnA200ResponseTest() throws Exception {
        // IDs obtained from JSON files
        // Arrange
        int followerId = 1001;
        int sellerId = 1000;
        String expectedMessage = ResponseMessages.SUCCESS_USER_FOLLOWED.format(followerId, sellerId);

        // Act and Assert
        mockMvc.perform(
                post("/users/{followerId}/follow/{sellerId}", followerId, sellerId)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    @Test
    @DisplayName("T-0001 - US-0001 - Follow yourself should return a 403 response test")
    void US_0001_followYourselfShouldReturnA404ResponseTest() throws Exception {
        // IDs obtained from JSON files
        // Arrange
        int followerId = 1001;
        String expectedMessage = ResponseMessages.ERROR_USER_ID_MATCH.format(followerId);

        // Act and Assert
        mockMvc.perform(
                        post("/users/{followerId}/follow/{sellerId}", followerId, followerId)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    @Test
    @DisplayName("T-0001 - US-0001 - Follower not found should return a 404 response test")
    void US_0001_followerNotFoundShouldReturnA403ResponseTest() throws Exception {
        // Arrange
        int followerId = 0;
        int sellerId = 1001;
        String expectedMessage = ResponseMessages.ERROR_USER_NOT_FOUND.format(followerId);

        // Act and Assert
        mockMvc.perform(
                        post("/users/{followerId}/follow/{sellerId}", followerId, sellerId)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    @Test
    @DisplayName("T-0001 - US-0001 - Seller not found should return a 404 response test")
    void US_0001_sellerNotFoundShouldReturnA403ResponseTest() throws Exception {
        // Arrange
        int followerId = 1000;
        int sellerId = 0;
        String expectedMessage = ResponseMessages.ERROR_USER_NOT_FOUND.format(sellerId);

        // Act and Assert
        mockMvc.perform(
                        post("/users/{followerId}/follow/{sellerId}", followerId, sellerId)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    @Test
    @DisplayName("T-0001 - US-0001 - Follow a non seller user should return a 400 response test")
    void US_0001_followANonSellerShouldReturnA400ResponseTest() throws Exception {
        // Arrange
        int followerId = 1001;
        int nonSellerId = 1003;
        String expectedMessage = ResponseMessages.ERROR_USER_NOT_SELLER.format(nonSellerId);

        // Act and Assert
        mockMvc.perform(
                        post("/users/{followerId}/follow/{sellerId}", followerId, nonSellerId)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    // TODO: this test won't work unless the "db" is restored on each run
//    @Test
//    @DisplayName("T-0001 - US-0001 - Follow an already following seller should return a 400 response test")
//    void US_0001_followAnAlreadyFollowingSellerShouldReturnA400ResponseTest() throws Exception {
//        // Arrange
//        int followerId = 1001;
//        int sellerId = 1000;
//        String expectedMessage = ResponseMessages.ERROR_USER_ALREADY_FOLLOWING.format(followerId, sellerId);
//
//        mockMvc.perform(
//                        post("/users/{followerId}/follow/{sellerId}", followerId, sellerId)
//                                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//        // Act and Assert
//        mockMvc.perform(
//                        post("/users/{followerId}/follow/{sellerId}", followerId, sellerId)
//                                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$.message").value(expectedMessage));
//
//    }



    @Test
    @DisplayName("T-0007 number of followers. Happy Path")
    void US_0002_OK() throws Exception {
        mockMvc.perform(get("/users/2004/followers/count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").value(2));
    }

    @Test
    @DisplayName("T-0007 user is not a seller")
    void US_0002_NotSeller() throws Exception {
        mockMvc.perform(get("/users/2003/followers/count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Seller with ID 2003 not found."));
    }

    @Test
    @DisplayName("T-0007 user not found")
    void US_0002_NotUserFound() throws Exception {
        mockMvc.perform(get("/users/0/followers/count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with ID 0 not found."));
    }

    @Test
    void US_0003(){

    }

    @Test
    @DisplayName("T-0004a search Followed List Ordered ASC")
    void US_0004_OrderedAsc() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/users/12004/followed/list")
                        .param("order", "name_asc")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        List<String> actualNames = JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.followed[*].user_name");
        List<String> expectedNames = List.of("Novak Djokovic", "Rafael Nadal", "Roger Federer");

        assertThat(actualNames).containsExactlyElementsOf(expectedNames);
    }
    @Test
    @DisplayName("US-0004b search Followed List Ordered DESC Happy path")
    void US_0004_OrderedDesc() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/users/12004/followed/list")
                        .param("order", "name_desc")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        List<String> actualNames = JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.followed[*].user_name");
        List<String> expectedNames = List.of("Roger Federer", "Rafael Nadal", "Novak Djokovic");

        assertThat(actualNames).containsExactlyElementsOf(expectedNames);
    }
    @Test
    @DisplayName("US-0004 search Followed List No Ordered Happy Path")
    void US_0004_OK() throws Exception {
        mockMvc.perform(get("/users/12004/followed/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(12004))
                .andExpect(jsonPath("$.user_name").value("David Nalbandian"))
                .andExpect(jsonPath("$.followed.length()").value(3)) // Verifica que hay 3 seguidos
                .andExpect(jsonPath("$.followed[0].user_name").value("Roger Federer"))
                .andExpect(jsonPath("$.followed[1].user_name").value("Rafael Nadal"))
                .andExpect(jsonPath("$.followed[2].user_name").value("Novak Djokovic"));
    }
    @Test
    @DisplayName("US-0004 search Followed List Not found (sad) Path")
    void US_0004_NOT_FOUND() throws Exception {
        int nonExistentUserId = 12005;

        mockMvc.perform(get("/users/{userId}/followed/list", nonExistentUserId)
                        .contentType("application/json"))
                .andExpect(status().isNotFound()) // Verifica HTTP 404
                .andExpect(jsonPath("$.message").value("User with ID 12005 not found."));
    }
    @Test
    @DisplayName("US-0004c search Followed List with Invalid Order Parameter")
    void US_0004_InvalidOrder() throws Exception {
        mockMvc.perform(get("/users/12004/followed/list")
                        .param("order", "wrong_param") // Enviamos un parámetro inválido
                        .contentType("application/json"))
                .andExpect(status().isBadRequest()) // Esperamos un HTTP 400
                .andExpect(jsonPath("$.message").value("The 'order' parameter can only be 'name_asc' or 'name_desc'."));
    }

    @Test
    @DisplayName("T-0002 US-0007 Unfollowed successfully.")
    void US_0007_OK() throws Exception {
        mockMvc.perform(post("/users/7001/unfollow/7000")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Unfollowed successfully."));
    }

    @Test
    @DisplayName("T-0002 US-0007 id is equal")
    void US_0007_ID_EQUAL() throws Exception {
        mockMvc.perform(post("/users/7001/unfollow/7001")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("The user ID 7001 cannot be the same as the target user ID."));
    }

    @Test
    @DisplayName("T-0002 US-0007 User is not a seller.")
    void US_0007_NOT_SELLER()throws Exception {
        mockMvc.perform(post("/users/7001/unfollow/7003")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("User with ID 7003 is not a seller."));
    }

    @Test
    @DisplayName("T-0002 US-0007 not following")
    void US_0007_NOT_FOLLOWING()throws Exception {
        mockMvc.perform(post("/users/7000/unfollow/7004")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("User with ID 7000 is not following seller with ID 7004."));
    }

    @Test
    @DisplayName("T-0002 US-0007 user not exist")
    void US_0007_USER_NOT_EXIST() throws Exception {
        mockMvc.perform(post("/users/7001/unfollow/0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with ID 0 not found."));
    }

    @Test
    void US_0008(){

    }
    @Test
    void US_0009(){

    }
}
