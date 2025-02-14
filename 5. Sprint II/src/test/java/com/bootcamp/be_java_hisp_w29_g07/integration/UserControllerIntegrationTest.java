package com.bootcamp.be_java_hisp_w29_g07.integration;

import com.bootcamp.be_java_hisp_w29_g07.constants.Messages;
import com.bootcamp.be_java_hisp_w29_g07.controller.UserController;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListFollowedDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListFollowersDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListFollowersDTO;
import com.bootcamp.be_java_hisp_w29_g07.repository.IFollowRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration test for the {@link UserController} controller.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    /**
     * Instance of {@link MockMvc} that allows simulating HTTP requests and verifying controller responses.
     */
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IFollowRepository followRepository;

    @BeforeEach
    void setUp() {
        followRepository.deleteAll();
    }

    /**
     * Integration Test to verify that a user can unfollow another user when the follower is already following the target user.
     * <p>
     * This test simulates a user unfollowing another user when the follow relationship exists.
     * It first performs a "follow" operation and then an "unfollow" operation.
     * It verifies that the response is a success message indicating that the user has successfully unfollowed.
     * </p>
     */
    @Test
    public void givenExistingFollow_whenUnfollowUserById_thenReturnSuccess() throws Exception {
        Integer userIdFollower = 1;
        Integer userIdToFollow = 2;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower, userIdToFollow))
                .andDo(print())
                .andExpect(status().isOk());


        MvcResult res = mockMvc.perform(
                        post("/users/{userId}/unfollow/{userIdToUnfollow}", userIdFollower, userIdToFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();

        assertTrue(jsonRes.contains(String.format(Messages.USER_HAS_UNFOLLOWED_USER, userIdFollower, userIdToFollow)));
    }

    /**
     * Integration Test to verify that an attempt to unfollow a user when no follow relationship exists
     * results in a 404 Not Found error.
     * <p>
     * This test simulates an attempt to unfollow a user when the follower is not following the target user.
     * It verifies that the system returns a 404 Not Found error with the appropriate error message.
     * </p>
     */
    @Test
    public void givenNonExistentFollow_whenUnfollowUserById_thenReturnNotFoundError() throws Exception {
        Integer userIdFollower = 1;
        Integer userIdToFollow = 2;

        MvcResult res = mockMvc.perform(
                        post("/users/{userId}/unfollow/{userIdToUnfollow}", userIdFollower, userIdToFollow))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();
        assertTrue(jsonRes.contains(String.format(Messages.USER_IS_NOT_FOLLOWING_USER, userIdFollower, userIdToFollow)));
    }


    /**
     * Integration Test to verify that an attempt to unfollow a user when the follower does not exist
     * results in a 404 Not Found error.
     * <p>
     * This test simulates an attempt to unfollow a user where the follower does not exist in the system.
     * It verifies that the system returns a 404 Not Found error with the appropriate error message.
     * </p>
     */
    @Test
    public void givenNonExistentUser_whenUnfollowUserById_thenReturnNotFoundError() throws Exception {
        Integer userIdFollower = 9999;
        Integer userIdToFollow = 2;

        MvcResult res = mockMvc.perform(
                        post("/users/{userId}/unfollow/{userIdToUnfollow}", userIdFollower, userIdToFollow))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();
        assertTrue(jsonRes.contains(String.format(Messages.USER_NOT_FOUND_MSG, userIdFollower)));
    }

    /**
     * Integration Test to verify that a seller with followers returns the correct follower count.
     * <p>
     * This test simulates users following a seller and then retrieves the follower count.
     * It verifies that the response contains the correct number of followers and the seller's user ID.
     * </p>
     */
    @Test
    void givenExistentSeller_whenGetSellerFollowerCount_thenReturnCorrectCountResponse() throws Exception {
        Integer userFollowerId1 = 1;
        Integer userFollowerId2= 3;
        Integer sellerFollowedId = 2;
        Long expectedFollowers = 2L;
        //Follow
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userFollowerId1, sellerFollowedId))
                .andExpect(status().isOk());

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userFollowerId2, sellerFollowedId))
                .andExpect(status().isOk());

        mockMvc.perform(get("/users/{userId}/followers/count", sellerFollowedId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.followers_count").value(expectedFollowers))
                .andExpect(jsonPath("$.user_id").value(sellerFollowedId));
    }


    /**
     * Integration Test to verify that a seller with no followers returns a count of zero.
     * <p>
     * This test retrieves the follower count for a seller who has no followers.
     * It verifies that the response correctly returns zero followers.
     * </p>
     */
    @Test
    void givenExistentSellerWithNoFollowers_whenGetSellerFollowerCount_thenReturnZeroCountResponse() throws Exception {
        Integer sellerFollowedId = 4;
        Long expectedFollowers = 0L;

        mockMvc.perform(get("/users/{userId}/followers/count", sellerFollowedId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.followers_count").value(expectedFollowers))
                .andExpect(jsonPath("$.user_id").value(sellerFollowedId));
    }

    /**
     * Integration Test to verify that retrieving follower count for a non-existent seller returns a 404 error.
     * <p>
     * This test attempts to retrieve the follower count for a seller that does not exist.
     * It verifies that the system returns a 404 Not Found error with the expected message.
     * </p>
     */
    @Test
    void givenNonExistentSeller_whenGetSellerFollowerCount_thenReturnNotFoundError() throws Exception {

        Integer sellerFollowedId = 99;
        String expectedMsg = String.format(Messages.USER_NOT_FOUND_MSG, sellerFollowedId);

        mockMvc.perform(get("/users/{userId}/followers/count", sellerFollowedId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expectedMsg));
    }

    /**
     * Integration Test to verify that retrieving follower count for a non-seller user returns a 400 error.
     * <p>
     * This test attempts to retrieve the follower count for a user that is not a seller.
     * It verifies that the system returns a 400 Bad Request error with the expected message.
     * </p>
     */
    @Test
    void givenNonSellerUserId_whenGetSellerFollowerCount_thenReturnUserNotSellerError() throws Exception {
        Integer sellerFollowedId = 1;
        String expectedMsg = Messages.USER_NOT_SELLER_MSG;

        mockMvc.perform(get("/users/{userId}/followers/count", sellerFollowedId))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expectedMsg));
    }

    /**
     * Integration Test to verify that an attempt to follow a user when both users exist
     * results in a successful follow operation.
     * <p>
     * This test simulates an attempt to follow another user when both the follower and the target user
     * exist in the system. It verifies that the system returns a success status with a message indicating
     * that the follower successfully followed the target user.
     * </p>
     */
    @Test
    void givenExistUser_whenAddFollow_thenReturnSuccess() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 5,4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("User Brayan Camilo follows user Juan Steven"));
    }

    /**
     * Integration Test to verify that an attempt to follow a user when the follower does not exist
     * results in a 404 Not Found error.
     * <p>
     * This test simulates an attempt to follow a user when the follower does not exist in the system.
     * It verifies that the system returns a 404 Not Found error with the appropriate error message,
     * indicating that the follower with the given id could not be found.
     * </p>
     */
    @Test
    void givenNotExistUser_whenAddFollow_thenReturnNotFoundError() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 115,2))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with id 115 not found"));
    }

    /**
     * Integration Test to verify that an attempt to follow a user when the follower id is invalid
     * results in a 400 Bad Request error.
     * <p>
     * This test simulates an attempt to follow a user when the provided follower id is invalid (non-numeric).
     * It verifies that the system returns a 400 Bad Request error, indicating that the request is malformed.
     * </p>
     */
    @Test
    void giveMalformedParameter_whenAddFollow_thenReturnNotFoundError() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "a",2))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * Integration Test to verify that when an existing user follows another user,
     * the followed user's list can be retrieved successfully.
     * <p>
     * This test simulates a scenario where a user follows another user.
     * It verifies that the system returns a successful response with the expected
     * ListFollowedDTO, confirming the user’s following status.
     * </p>
     */
    @Test
    public void givenExistingUser_whenFindListFollowedByUserId_thenReturnSuccess() throws Exception {
        Integer userIdFollower = 1;
        Integer userIdToFollow = 2;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower, userIdToFollow))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult res = mockMvc.perform(get("/users/{userId}/followed/list", userIdFollower))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();
        ListFollowedDTO listFollowedDTO = new ObjectMapper().readValue(jsonRes, new TypeReference<ListFollowedDTO>() {
        });

        assertEquals("alargo", listFollowedDTO.getUserName());
        assertEquals(1, listFollowedDTO.getId());
        assertEquals(1, listFollowedDTO.getFollowed().size());
        assertEquals("cmorales", listFollowedDTO.getFollowed().getFirst().getUserName());
        assertEquals(2, listFollowedDTO.getFollowed().getFirst().getUserId());
    }


    /**
     * Integration Test to verify that an attempt to unfollow a user when the user ID is invalid
     * <p>
     * This test simulates an attempt to unfollow a user when the provided follower id is invalid
     * (non-existent). It verifies that the system returns a 404 Not Found error,
     * indicating that the user to unfollow does not exist in the system.
     * </p>
     */
    @Test
    public void givenNoExistingUser_whenFindListFollowedByUserId_thenReturnError() throws Exception {
        Integer userId = 99;

        MvcResult res = mockMvc.perform(get("/users/{userId}/followed/list", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();

        assertTrue(jsonRes.contains(String.format(Messages.USER_NOT_FOUND_MSG, userId)));
    }

    /**
     * Test to verify that the list of followed users is returned in ascending order by username
     * when the "name_asc" order parameter is provided.
     * <p>
     * It simulates a user following two other users and then retrieves the followed list,
     * ensuring the list is correctly ordered and the response data matches the expected values.
     * </p>
     */
    @Test
    public void givenExistingUserAndOrderAsc_whenFindListFollowedByUserId_thenReturnSuccessOrderedList() throws Exception {
        Integer userIdFollower = 1;
        Integer userIdToFollow1 = 2;
        Integer userIdToFollow2 = 4;
        String userNameToFollow1 = "cmorales";
        String userNameToFollow2 = "jfeo";

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower, userIdToFollow1))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower, userIdToFollow2))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult res = mockMvc.perform(get("/users/{userId}/followed/list", userIdFollower)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();
        ListFollowedDTO listFollowedDTO = new ObjectMapper().readValue(jsonRes, new TypeReference<ListFollowedDTO>() {});

        assertEquals(1, listFollowedDTO.getId());
        assertEquals(2, listFollowedDTO.getFollowed().size());
        assertEquals(userNameToFollow1, listFollowedDTO.getFollowed().getFirst().getUserName());
        assertEquals(userNameToFollow2, listFollowedDTO.getFollowed().get(1).getUserName());
    }

    /**
     * Test to verify that the list of followed users is returned in descending order by username
     * when the "name_desc" order parameter is provided.
     * <p>
     * It simulates a user following two other users and then retrieves the followed list,
     * ensuring the list is correctly ordered and the response data matches the expected values.
     * </p>
     */
    @Test
    public void givenExistingUserAndOrderDesc_whenFindListFollowedByUserId_thenReturnSuccessOrderedList() throws Exception {
        Integer userIdFollower = 1;
        Integer userIdToFollow1 = 4;
        Integer userIdToFollow2 = 2;
        String userNameToFollow1 = "jfeo";
        String userNameToFollow2 = "cmorales";

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower, userIdToFollow1))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower, userIdToFollow2))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult res = mockMvc.perform(get("/users/{userId}/followed/list", userIdFollower)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();
        ListFollowedDTO listFollowedDTO = new ObjectMapper().readValue(jsonRes, new TypeReference<ListFollowedDTO>() {});

        assertEquals(1, listFollowedDTO.getId());
        assertEquals(2, listFollowedDTO.getFollowed().size());
        assertEquals(userNameToFollow1, listFollowedDTO.getFollowed().getFirst().getUserName());
        assertEquals(userNameToFollow2, listFollowedDTO.getFollowed().get(1).getUserName());
    }

    /**
     * Test to verify that the list of followers users is returned in ascending order by username
     * when the "name_asc" order parameter is provided.
     * <p>
     * It simulates two users following other user and then retrieves the followers list,
     * ensuring the list is correctly ordered and the response data matches the expected values.
     * </p>
     */
    @Test
    public void givenExistingUserAndOrderAsc_whenFindListFollowersByUserId_thenReturnSuccessOrderedList() throws Exception {
        Integer userFollowed = 2;
        Integer userIdFollower1 = 3;
        Integer userIdFollower2 = 1;
        Integer userIdFollower3 = 5;
        String userNameFollower1 = "acano";
        String userNameFollower2 = "alargo";
        String userNameFollower3 = "bsanchez";

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower1, userFollowed))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower2, userFollowed))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower3, userFollowed))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult res = mockMvc.perform(get("/users/{userId}/followers/list", userFollowed)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();
        ListFollowersDTO listFollowedDTO = new ObjectMapper().readValue(jsonRes, new TypeReference<ListFollowersDTO>() {});

        assertEquals(2, listFollowedDTO.getUser_id());
        assertEquals(3, listFollowedDTO.getFollowers().size());
        assertEquals(userNameFollower1, listFollowedDTO.getFollowers().getFirst().getUserName());
        assertEquals(userNameFollower2, listFollowedDTO.getFollowers().get(1).getUserName());
        assertEquals(userNameFollower3, listFollowedDTO.getFollowers().get(2).getUserName());
    }

    /**
     * Test to verify that the list of followers users is returned in descending order by username
     * when the "name_desc" order parameter is provided.
     * <p>
     * It simulates two users following other user and then retrieves the followers list,
     * ensuring the list is correctly ordered and the response data matches the expected values.
     * </p>
     */
    @Test
    public void givenExistingUserAndOrderDesc_whenFindListFollowersByUserId_thenReturnSuccessOrderedList() throws Exception {
        Integer userFollowed = 2;
        Integer userIdFollower1 = 3;
        Integer userIdFollower2 = 1;
        Integer userIdFollower3 = 5;
        String userNameFollower1 = "bsanchez";
        String userNameFollower2 = "alargo";
        String userNameFollower3 = "acano";

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower1, userFollowed))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower2, userFollowed))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdFollower3, userFollowed))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult res = mockMvc.perform(get("/users/{userId}/followers/list", userFollowed)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();
        ListFollowersDTO listFollowedDTO = new ObjectMapper().readValue(jsonRes, new TypeReference<ListFollowersDTO>() {});

        assertEquals(2, listFollowedDTO.getUser_id());
        assertEquals(3, listFollowedDTO.getFollowers().size());
        assertEquals(userNameFollower1, listFollowedDTO.getFollowers().getFirst().getUserName());
        assertEquals(userNameFollower2, listFollowedDTO.getFollowers().get(1).getUserName());
        assertEquals(userNameFollower3, listFollowedDTO.getFollowers().get(2).getUserName());
    }


    /**
     * Test that verifies the controller returns a BadRequest status with an appropriate error message
     * when the 'findListFollowedByUserId' method is called with a user ID and an invalid order parameter.
     * <p>
     * In this case, the request is simulated with a user ID and an order parameter ("asc").
     * The controller is expected to respond with a BadRequest status and a message indicating
     * that the order does not exist.
     * </p>
     * @throws Exception if an error occurs during the test execution.
     */
    @Test
    public void givenUserIdAndNotExistingOrder_whenFindListFollowed_thenReturnException() throws Exception {
        MvcResult res = mockMvc.perform(get("/users/{userId}/followed/list", 1)
                        .param("order", "asc"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();

        assertTrue(jsonRes.contains(Messages.ORDER_DOES_NOT_EXIST));
    }

    /**
     * Test that verifies the controller returns a BadRequest status with an appropriate error message
     * when the 'findListFollowersByUserId' method is called with a user ID and an invalid order parameter.
     * <p>
     * In this case, the request is simulated with a user ID and an order parameter ("desc").
     * The controller is expected to respond with a BadRequest status and a message indicating
     * that the order does not exist.
     * </p>
     * @throws Exception if an error occurs during the test execution.
     */
    @Test
    public void givenUserIdAndNotExistingOrder_whenFindListFollowers_thenReturnException() throws Exception {
        MvcResult res = mockMvc.perform(get("/users/{userId}/followers/list", 1)
                        .param("order", "desc"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonRes = res.getResponse().getContentAsString();

        assertTrue(jsonRes.contains(Messages.ORDER_DOES_NOT_EXIST));
    }


    /**
     * Integration Test to verify that when an existing user has followers,
     * the followers' list can be retrieved successfully.
     * <p>
     * This test simulates a scenario where a user has followers.
     * It verifies that the system returns a successful response with the expected
     * ListFollowersDTO, confirming the user's followers' status.
     * </p>
     */
    @Test
    void givenExistFollows_whenFindListFollowersByUserId_thenReturnSuccess() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andExpect(status().isOk());

        MvcResult result = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list",2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        ListFollowersDTO ListFollowersDTO = new ObjectMapper().readValue(jsonResult, new TypeReference<ListFollowersDTO>() {
        });

        assertEquals("cmorales", ListFollowersDTO.getUser_name());
        assertEquals(2, ListFollowersDTO.getUser_id());
        assertEquals(1, ListFollowersDTO.getFollowers().size());
        assertEquals("alargo", ListFollowersDTO.getFollowers().getFirst().getUserName());
        assertEquals(1, ListFollowersDTO.getFollowers().getFirst().getUserId());
    }

    /**
     * Integration Test to verify that when a non-existent user is queried for followers,
     * a 404 Not Found error is returned.
     * <p>
     * This test simulates an attempt to retrieve the followers' list of a non-existent user.
     * It verifies that the system returns a 404 Not Found error, indicating that the user
     * does not exist in the system.
     * </p>
     */
    @Test
    void givenNoExistingUser_whenFindListFollowersByUserId_thenReturnNotFoundError() throws Exception {


        MvcResult result = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list",20))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        assertTrue(jsonResult.contains(String.format(Messages.USER_NOT_FOUND_MSG, 20)));
    }
}
