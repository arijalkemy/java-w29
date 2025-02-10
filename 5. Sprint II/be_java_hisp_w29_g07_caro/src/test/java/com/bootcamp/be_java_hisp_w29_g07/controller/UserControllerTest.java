package com.bootcamp.be_java_hisp_w29_g07.controller;

import com.bootcamp.be_java_hisp_w29_g07.constants.Messages;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListFollowedDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.ListFollowersDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.MessageDTO;
import com.bootcamp.be_java_hisp_w29_g07.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import com.bootcamp.be_java_hisp_w29_g07.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w29_g07.service.IFollowService;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilUserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit test class for {@link UserController}.
 */
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    /**
     * Mocked instance of {@link IFollowService} used for testing the controller's behavior
     * without calling the actual service methods.
     */
    @Mock
    private IFollowService followService;

    /**
     * Instance of {@link UserController} with mocked dependencies injected for unit testing.
     * The controller's methods are tested here using mocked services.
     */
    @InjectMocks
    private UserController userController;

    /**
     * Unit Test to verify that when a user successfully unfollows another user,
     * the appropriate success ResponseEntity with the message is returned.
     */
    @Test
    public void givenExistingFollow_whenUnfollowUserById_thenReturnSuccessResponseEntity() {
        Integer userIdFollower = 1;
        Integer userIdFollowed = 2;
        MessageDTO messageDTO = new MessageDTO(String.format(Messages.USER_HAS_UNFOLLOWED_USER, userIdFollower, userIdFollowed));
        when(followService.unfollowUserById(userIdFollower, userIdFollowed)).thenReturn(messageDTO);

        ResponseEntity<MessageDTO> response = userController.unfollowUserById(userIdFollower, userIdFollowed);

        verify(followService).unfollowUserById(userIdFollower, userIdFollowed);
        assertEquals(messageDTO, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(messageDTO.getMessage(), response.getBody().getMessage());
    }

    /**
     * Unit Test to verify that when a user successfully follows a seller,
     * the appropriate success ResponseEntity with the message is returned.
     */
    @Test
    public void givenUserFollowSeller_whenAddFollow_thenReturnSuccessResponseEntity() {
        User user = UtilUserFactory.getUser("jfeo");
        User userToFollow = UtilUserFactory.getUser("alargo");
        MessageDTO message = new MessageDTO(String.format(Messages.USER_FOLLOW_SELLER, user.getName(), userToFollow.getName()));
        when(followService.saveFollow(user.getId(), userToFollow.getId())).thenReturn(message);

        ResponseEntity<MessageDTO> response = userController.addFollow(user.getId(), userToFollow.getId());

        assertEquals(message, response.getBody());
    }

    /**
     * Unit Test to verify that when a user requests the list of users they are following,
     * the appropriate ResponseEntity containing the ListFollowedDTO is returned.
     */
    @Test
    public void givenExistingUser_whenFindListFollowedByUserId_thenReturnListFollowedDTO()
    {
        Integer userId = 1;
        String order = null;

        ListFollowedDTO mockResponse = new ListFollowedDTO(userId,"steven", new ArrayList<>());

        when(followService.findListFollowedByUserId(userId,order)).thenReturn(mockResponse);

        ResponseEntity<ListFollowedDTO> response = userController.findListFollowedByUserId(userId,order);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse,response.getBody());
        assertNotNull(response.getBody());

        verify(followService).findListFollowedByUserId(userId,order);
    }

    /**
     * Unit Test to verify that when a user requests the list of followers,
     * the appropriate ResponseEntity containing the ListFollowersDTO is returned.
     */
    @Test
    public void givenExistingUser_whenFindListFollowersByUserId_thenReturnListFollowersDTO()
    {
        Integer userId = 1;

        ListFollowersDTO mockResponse = new ListFollowersDTO(userId,"bsanchez", new ArrayList<>());

        when(followService.findListFollowersByUserId(userId, null)).thenReturn(mockResponse);

        ResponseEntity<ListFollowersDTO> response = userController.findListFollowersByUserId(userId, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse,response.getBody());
        assertNotNull(response.getBody());

        verify(followService).findListFollowersByUserId(userId, null);
    }
    /**
     * Unit test to verify that the list of followed users is correctly ordered by username in ascending order
     * when the "name_asc" order parameter is provided.
     */
    @Test
    public void givenUserIdAndOrderAsc_whenFindListFollowed_thenReturnSuccessListOrdered() {
        Integer userId = 1;
        String userName = "alargo";
        String order = "name_asc";
        ListFollowedDTO followedDTO = new ListFollowedDTO(userId,userName,
                Arrays.asList(
                        new UserDTO(2, "cmorales"),
                        new UserDTO(4, "jfeo")
                ));

        when(followService.findListFollowedByUserId(userId, order)).thenReturn(followedDTO);

        ResponseEntity<ListFollowedDTO> response = userController.findListFollowedByUserId(userId ,order);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(followedDTO, response.getBody());
        assertNotNull(response.getBody());
        assertEquals(followedDTO.getFollowed().getFirst().getUserName(), response.getBody().getFollowed().getFirst().getUserName());
        assertEquals(followedDTO.getFollowed().get(1).getUserName(), response.getBody().getFollowed().get(1).getUserName());
    }

    /**
     * Unit test to verify that the list of followed users is correctly ordered by username in descending order
     * when the "name_asc" order parameter is provided.
     */
    @Test
    public void givenUserIdAndOrderDesc_whenFindListFollowed_thenReturnSuccessListOrdered() {
        Integer userId = 1;
        String userName = "alargo";
        String order = "name_desc";
        ListFollowedDTO followedDTO = new ListFollowedDTO(userId,userName,
                Arrays.asList(
                        new UserDTO(4, "jfeo"),
                        new UserDTO(2, "cmorales")
                ));

        when(followService.findListFollowedByUserId(userId, order)).thenReturn(followedDTO);

        ResponseEntity<ListFollowedDTO> response = userController.findListFollowedByUserId(userId ,order);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(followedDTO, response.getBody());
        assertNotNull(response.getBody());
        assertEquals(followedDTO.getFollowed().getFirst().getUserName(), response.getBody().getFollowed().getFirst().getUserName());
        assertEquals(followedDTO.getFollowed().get(1).getUserName(), response.getBody().getFollowed().get(1).getUserName());
    }

    /**
     * Unit test to verify that the list of followers users is correctly ordered by username in ascending order
     * when the "name_asc" order parameter is provided.
     */
    @Test
    public void givenUserIdAndOrderAsc_whenFindListFollowers_thenReturnSuccessListOrdered() {
        Integer userId = 2;
        String userName = "cmorales";
        String order = "name_asc";
        ListFollowersDTO followersDTO = new ListFollowersDTO(userId,userName,
                Arrays.asList(
                        new UserDTO(3, "acano"),
                        new UserDTO(1, "alargo"),
                        new UserDTO(5, "bsanchez")
                ));

        when(followService.findListFollowersByUserId(userId, order)).thenReturn(followersDTO);

        ResponseEntity<ListFollowersDTO> response = userController.findListFollowersByUserId(userId ,order);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(followersDTO, response.getBody());
        assertNotNull(response.getBody());
        assertEquals(followersDTO.getFollowers().getFirst().getUserName(), response.getBody().getFollowers().getFirst().getUserName());
        assertEquals(followersDTO.getFollowers().get(1).getUserName(), response.getBody().getFollowers().get(1).getUserName());
    }

    /**
     * Unit test to verify that the list of followers users is correctly ordered by username in descending order
     * when the "name_asc" order parameter is provided.
     */
    @Test
    public void givenUserIdAndOrderDesc_whenFindListFollowers_thenReturnSuccessListOrdered() {
        Integer userId = 2;
        String userName = "cmorales";
        String order = "name_asc";
        ListFollowersDTO followersDTO = new ListFollowersDTO(userId,userName,
                Arrays.asList(
                        new UserDTO(5, "bsanchez"),
                        new UserDTO(1, "alargo"),
                        new UserDTO(3, "acano")
                ));

        when(followService.findListFollowersByUserId(userId, order)).thenReturn(followersDTO);

        ResponseEntity<ListFollowersDTO> response = userController.findListFollowersByUserId(userId ,order);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(followersDTO, response.getBody());
        assertNotNull(response.getBody());
        assertEquals(followersDTO.getFollowers().getFirst().getUserName(), response.getBody().getFollowers().getFirst().getUserName());
        assertEquals(followersDTO.getFollowers().get(1).getUserName(), response.getBody().getFollowers().get(1).getUserName());
    }

    /**
     * Unit Test to verify that an exception is thrown when an invalid order parameter is provided
     * while trying to retrieve the list of followed. It checks that a `BadRequestException`
     * is thrown when the order is neither "name_asc" nor "name_desc", and verifies that the
     * appropriate methods are called.
     */
    @Test
    public void givenUserIdAndNotExistingOrder_whenFindListFollowed_thenReturnException() {
        Integer userId = 1;
        String order = "asc";

        when(followService.findListFollowedByUserId(userId,order)).thenThrow(BadRequestException.class);

        assertThrows(BadRequestException.class, () -> userController.findListFollowedByUserId(userId, order));
        verify(followService, atLeastOnce()).findListFollowedByUserId(userId, order);
    }

    /**
     * Unit Test to verify that an exception is thrown when an invalid order parameter is provided
     * while trying to retrieve the list of followers. It checks that a `BadRequestException`
     * is thrown when the order is neither "name_asc" nor "name_desc", and verifies that the
     * appropriate methods are called.
     */
    @Test
    public void givenUserIdAndNotExistingOrder_whenFindListFollowers_thenReturnException() {
        Integer userId = 1;
        String order = "desc";

        when(followService.findListFollowersByUserId(userId,order)).thenThrow(BadRequestException.class);

        assertThrows(BadRequestException.class, () -> userController.findListFollowersByUserId(userId, order));
        verify(followService, atLeastOnce()).findListFollowersByUserId(userId, order);
    }
}
