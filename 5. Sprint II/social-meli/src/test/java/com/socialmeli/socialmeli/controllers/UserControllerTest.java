package com.socialmeli.socialmeli.controllers;

import com.socialmeli.socialmeli.dto.response.UserFollowerCountDto;
import com.socialmeli.socialmeli.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.socialmeli.socialmeli.utils.UserFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // US 0001 - Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.
    @Test
    @DisplayName("#1 follow - successful")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void followTest_whenSuccessful_then200() throws Exception {
        // Arrange
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        User user5 = UserFactory.createSeller(5, "Franca Pairetti");

        String message = "Agostina Avalle followed successfully";

        // Act & Assert
        performFollow(user5.getId(), user1.getId(), message, 200);
    }

    @Test
    @DisplayName("#2 follow - user follower not found")
    public void followTest_whenUserFollowerDoesntExist_thenReturn404() throws Exception {
        // Arrange
        Integer userFollowerId = 999;
        Integer userFollowedId = 2;

        String message = "User with ID 999 not found";

        // Act & Assert
        performFollow(userFollowerId, userFollowedId, message, 404);
    }

    @Test
    @DisplayName("#3 follow - user followed not found")
    public void followTest_whenUserFollowedDoesntExist_thenReturn404() throws Exception {
        // Arrange
        Integer userFollowerId = 1;
        Integer userFollowedId = 999;

        String message = "User with ID 999 not found";

        // Act & Assert
        performFollow(userFollowerId, userFollowedId, message, 404);
    }

    @Test
    @DisplayName("#4 follow - user followed not seller")
    public void followTest_whenUserFollowedIsNotSeller_thenReturn400() throws Exception {
        // Arrange
        Integer userIdSeller = 1;
        User userNotSeller = UserFactory.createBuyer(2, "Carolina Comba");

        String message = "Carolina Comba is not a seller";

        // Act & Assert
        performFollow(userIdSeller, userNotSeller.getId(), message, 400);
    }

    @Test
    @DisplayName("#5 follow - user followed is the same as follower")
    public void followTest_whenUserFollowedIsTheSameAsFollower_thenReturn400() throws Exception {
        // Arrange
        Integer userId = 1;
        String message = "You cannot follow yourself";

        // Act & Assert
        performFollow(userId, userId, message, 400);
    }

    @Test
    @DisplayName("#6 follow - user already followed")
    public void followTest_whenUserAlreadyFollowed_thenReturn409() throws Exception {
        // Arrange
        User user2 = UserFactory.createBuyer(2, "Carolina Comba");
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");

        String message = "Agostina Avalle is already followed by Carolina Comba";

        // Act & Assert
        performFollow(user2.getId(), user1.getId(), message, 409);
    }

    @Test
    @DisplayName("#7 follow - invalid user follower id")
    void followTest_whenUserFollowerIdInvalid_thenReturn400() throws Exception {
        // Arrange
        Integer userFollowerId = -1;
        Integer userFollowedId = 1;

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userFollowerId, userFollowedId))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("#8 follow - invalid user followed id")
    void followTest_whenUserFollowedIdInvalid_thenReturn400() throws Exception {
        // Arrange
        Integer userFollowerId = 1;
        Integer userFollowedId = -1;

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userFollowerId, userFollowedId))
                .andExpect(status().isBadRequest());
    }

    //US-0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @Test
    @DisplayName("#9 countFollowersForSeller - successful")
    public void getCountFollowerForSellerTest_wheUserExists_thenReturnUserFollowerCountDto() throws Exception {
        // Arrange
        UserFollowerCountDto user1 = new UserFollowerCountDto(1, "Agostina Avalle", 3);

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/count", user1.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(user1.getId()))
                .andExpect(jsonPath("$.user_name").value(user1.getName()))
                .andExpect(jsonPath("$.followers_count").value(user1.getFollowersCount()));
    }

    @Test
    @DisplayName("#10 countFollowersForSeller - user not found")
    public void getCountFollowerForSellerTest_whenUserNotfound_thenReturn404() throws Exception {
        // Arrange
        Integer userId = 999;
        String message = "User with ID 999 not found";

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message));
    }

    @Test
    @DisplayName("#11 countFollowersForSeller - user not seller")
    public void getCountFollowerForSellerTest_whenUserNotSeller_thenReturn400() throws Exception {
        // Arrange
        User userNotSeller = UserFactory.createBuyer(2, "Carolina Comba");
        String message = "Carolina Comba is not a seller";

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/count", userNotSeller.getId()))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message));
    }

    @Test
    @DisplayName("#12 countFollowersForSeller - INVALID ID")
    public void getCountFollowerForSellerTest_whenInvalidId_thenReturn400() throws Exception {
        //Arrange
        Integer userId = -1;

        //Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andExpect(status().isBadRequest());
    }

    // US 0003 - Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?).
    @Test
    @DisplayName("#13 getFollowerUsers - successful with name_desc")
    public void getFollowerUsersTest_whenOrderByNameDesc_thenReturnOrderedList()
            throws Exception {
        // Arrange
        String order = "name_desc";
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        List<User> usersExpected = UserFactory.getFollowersListForUser1Desc();

        // Act & Assert
        ResultActions result = mockMvc.perform(get("/users/{userId}/followers/list", user1.getId())
                        .param("order", order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(user1.getId()))
                .andExpect(jsonPath("$.user_name").value(user1.getName()))
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers.length()").value(usersExpected.size()));

        for (int i = 0; i < usersExpected.size(); i++) {
            String expectedName = usersExpected.get(i).getName();
            Integer expectedId = usersExpected.get(i).getId();
            result.andExpect(jsonPath("$.followers[" + i + "].user_id").value(expectedId))
                    .andExpect(jsonPath("$.followers[" + i + "].user_name").value(expectedName));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "DEFAULT"})
    @DisplayName("#13 getFollowerUsers - successful with name_asc or default")
    public void getFollowerUsersTest_whenOrderByNameDAscOrDefault_thenReturnOrderedList(String order)
            throws Exception {
        // Arrange
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        List<User> usersExpected = UserFactory.getFollowersListForUser1Asc();

        // Act & Assert
        ResultActions result = mockMvc.perform(get("/users/{userId}/followers/list", user1.getId())
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(user1.getId()))
                .andExpect(jsonPath("$.user_name").value(user1.getName()))
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers.length()").value(usersExpected.size()));

        for (int i = 0; i < usersExpected.size(); i++) {
            String expectedName = usersExpected.get(i).getName();
            Integer expectedId = usersExpected.get(i).getId();
            result.andExpect(jsonPath("$.followers[" + i + "].user_id").value(expectedId))
                    .andExpect(jsonPath("$.followers[" + i + "].user_name").value(expectedName));
        }
    }

    @ParameterizedTest
    @DisplayName("#14 getFollowerUsers - user not found")
    @ValueSource(strings = {"name_asc", "name_desc", "DEFAULT"})
    public void getFollowerUsersTest_whenUserDoesntExists_thenReturn404(String order) throws Exception {
        // Arrange
        Integer userId = 999;
        String message = "User with ID 999 not found";

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message));
    }

    @ParameterizedTest
    @DisplayName("#15 getFollowerUsers - user not seller")
    @ValueSource(strings = {"name_asc", "name_desc", "DEFAULT"})
    public void getFollowerUsersTest_whenUserDoesntExists_thenReturn400(String order) throws Exception {
        // Arrange
        User user = UserFactory.createBuyer(2, "Carolina Comba");
        String message = "Carolina Comba is not a seller";

        // Act & Assert
        mockMvc.perform(get("/users/{userId}/followers/list", user.getId())
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message));
    }

    @Test
    @DisplayName("#16 getFollowerUsers - order invalid")
    public void getFollowerUsersTest_whenOrderInvalid_thenReturn400() throws Exception {
        // Arrange
        String order = "asdasf";

        // Act & Assert:
        mockMvc.perform(get("/users/{userId}/followers/list", 1)
                        .param("order", order))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @DisplayName("#17 getFollowerUsers - user id invalid")
    @ValueSource(strings = {"name_asc", "name_desc", "DEFAULT"})
    public void getFollowerUsersTest_whenUserIdInvalid_thenReturn400(String order) throws Exception {
        // Arrange
        Integer userId = -1;

        // Act & Assert:
        mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isBadRequest());
    }

    // US 0004 - Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?).
    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "DEFAULT"})
    @DisplayName("#18 getFollowedUsers - successful with name_asc or default")
    public void getFollowedUsersTest_whenOrderIsAscOrDefault_thenReturnOrderedList(String order)
            throws Exception {
        // Arrange
        User user2 = UserFactory.createBuyer(2, "Carolina Comba");
        List<User> usersExpected = UserFactory.getFollowedListForUser2Asc();

        // Act & Assert
        ResultActions result = mockMvc.perform(get("/users/{userId}/followed/list", user2.getId())
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(user2.getId()))
                .andExpect(jsonPath("$.user_name").value(user2.getName()))
                .andExpect(jsonPath("$.followed").isArray())
                .andExpect(jsonPath("$.followed.length()").value(usersExpected.size()));

        for (int i = 0; i < usersExpected.size(); i++) {
            String expectedName = usersExpected.get(i).getName();
            Integer expectedId = usersExpected.get(i).getId();
            result.andExpect(jsonPath("$.followed[" + i + "].user_id").value(expectedId))
                    .andExpect(jsonPath("$.followed[" + i + "].user_name").value(expectedName));
        }
    }

    @Test
    @DisplayName("#18 getFollowedUsers - successful with name_desc")
    public void getFollowedUsersTest_whenOrderIsParametrizedOrNotProvided_thenReturnOrderedList()
            throws Exception {
        // Arrange
        String order = "name_desc";
        User user2 = UserFactory.createBuyer(2, "Carolina Comba");
        List<User> usersExpected = UserFactory.getFollowedListForUser2Desc();

        // Act & Assert
        ResultActions result = mockMvc.perform(get("/users/{userId}/followed/list", user2.getId())
                        .param("order", order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(user2.getId()))
                .andExpect(jsonPath("$.user_name").value(user2.getName()))
                .andExpect(jsonPath("$.followed").isArray())
                .andExpect(jsonPath("$.followed.length()").value(usersExpected.size()));

        for (int i = 0; i < usersExpected.size(); i++) {
            String expectedName = usersExpected.get(i).getName();
            Integer expectedId = usersExpected.get(i).getId();
            result.andExpect(jsonPath("$.followed[" + i + "].user_id").value(expectedId))
                    .andExpect(jsonPath("$.followed[" + i + "].user_name").value(expectedName));
        }
    }

    @Test
    @DisplayName("#19 testFollowedListOrder - invalid order")
    public void testFollowedListOrderException() throws Exception {
        // Arrange
        String order = "nam";

        // Act & Assert:
        mockMvc.perform(get("/users/{userId}/followed/list", 1)
                        .param("order", order))
                .andExpect(status().isBadRequest());
    }

    @ParameterizedTest
    @DisplayName("#20 getFollowedUsers - user not found")
    @ValueSource(strings = {"name_asc", "name_desc", "DEFAULT"})
    public void getFollowedUsersTest_whenUserNotFound_thenReturn404(String order) throws Exception {
        // Arrange
        Integer userId = 999;

        // Act & Assert:
        mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isNotFound());
    }

    @ParameterizedTest
    @DisplayName("#21 getFollowedUsers - invalid user id")
    @ValueSource(strings = {"name_asc", "name_desc", "DEFAULT"})
    public void getFollowedUsersTest_whenUserIdInvalid_thenReturn400(String order) throws Exception {
        // Arrange
        Integer userId = -1;

        // Act & Assert:
        mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .param("order", "DEFAULT".equals(order) ? "" : order))
                .andExpect(status().isBadRequest());
    }

    // US 0007 - Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @Test
    @DisplayName("#32 unfollowToUserTest - successful")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void unfollowUserTest_whenSuccessfull_thenReturn200() throws Exception {
        // Arrange
        User follower = UserFactory.createBuyer(2, "Carolina Comba");
        User followed = UserFactory.createSeller(1, "Agostina Avalle");

        String expectedMessage = "Agostina Avalle unfollowed successfully";

        // Act & Assert
        performUnfollow(follower.getId(), followed.getId(), expectedMessage, 200);
    }

    @Test
    @DisplayName("#33 unfollowToUserTest - user followed not found")
    public void unfollowUserTest_whenUserFollowedDoesntExists_thenReturn404() throws Exception {
        // Arrange
        User follower = UserFactory.createBuyer(2, "Carolina Comba");
        User followed = UserFactory.createSeller(999);

        String expectedMessage = "User with ID 999 not found";

        // Act & Assert
        performUnfollow(follower.getId(), followed.getId(), expectedMessage, 404);
    }

    @Test
    @DisplayName("#34 unfollowToUserTest - user follower not found")
    public void unfollowUserTest_whenUserFollowerDoesntExists_thenReturn404() throws Exception {
        // Arrange
        User follower = UserFactory.createBuyer(999);
        User followed = UserFactory.createSeller(1, "Agostina Avalle");

        String expectedMessage = "User with ID 999 not found";

        // Act & Assert
        performUnfollow(follower.getId(), followed.getId(), expectedMessage, 404);
    }

    @Test
    @DisplayName("#35 unfollow - invalid user followed id")
    void unfollowTest_whenUserFollowedIdInvalid_thenReturn400() throws Exception {
        // Arrange
        Integer userFollowerId = 1;
        Integer userFollowedId = -1;

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userFollowerId, userFollowedId))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("#36 unfollow - invalid user follower id")
    void unfollowTest_whenUserFollowerIdInvalid_thenReturn400() throws Exception {
        // Arrange
        Integer userFollowerId = -1;
        Integer userFollowedId = 1;

        // Act & Assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userFollowerId, userFollowedId))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("#37 unfollowToUserTest - follower try to unfollow to user that is not following")
    public void unfollowUserTest_whenFollowDoesntExists_thenReturn404() throws Exception {
        // Arrange
        User follower = UserFactory.createBuyer(2, "Carolina Comba");
        User followed = UserFactory.createSeller(6, "Katerinne Peralta");

        String expectedMessage = "Katerinne Peralta is not followed by Carolina Comba";

        // Act & Assert
        performUnfollow(follower.getId(), followed.getId(), expectedMessage, 409);
    }

    @Test
    @DisplayName("#38 unfollowToUserTest - follower try to unfollow yourself")
    public void unfollowUserTest_whenFollowerTryToUnfollowYourself_thenReturn400() throws Exception {
        // Arrange
        User follower = UserFactory.createBuyer(2, "Carolina Comba");

        String expectedMessage = "You cannot unfollow yourself";

        // Act & Assert
        performUnfollow(follower.getId(), follower.getId(), expectedMessage, 400);
    }

    // Métodos privados
    private void performFollow(Integer followerId, Integer followedId, String expectedMessage, int expectedStatus)
            throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", followerId, followedId))
                .andExpect(status().is(expectedStatus))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    private void performUnfollow(Integer followerId, Integer followedId, String expectedMessage, int expectedStatus)
            throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", followerId, followedId))
                .andExpect(status().is(expectedStatus))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }
}
