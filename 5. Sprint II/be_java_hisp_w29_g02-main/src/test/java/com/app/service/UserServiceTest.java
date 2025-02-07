package com.app.service;

import com.app.dto.response.SuccessDTO;
import com.app.exception.BadRequestException;
import com.app.exception.EntityNotFoundException;
import com.app.exception.ForbiddenException;
import com.app.model.User;
import com.app.repository.IUserRepository;
import com.app.util.ResponseMessages;
import com.app.utils.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private Optional<User> user;
    private List<User> followerList;
    private List<User> followdList;

    @BeforeEach
    public void setUp() {
        user = UserUtils.createUser();
        followerList = UserUtils.createFollowerList();
        followdList = UserUtils.createFollowedList();
    }

    @Test
    @DisplayName("T-0001 US-0001 - Follow a seller - Happy path test")
    void followSellerUserTest() {
        // Arrange
        User follower = User
                .builder()
                .name("Carlos")
                .following(new ArrayList<>())
                .id(1)
                .build();

        User seller = User
                .builder()
                .id(2)
                .name("Alfredo")
                .followers(new ArrayList<>())
                .isSeller(true)
                .build();

        when(userRepository.findById(follower.getId())).thenReturn(Optional.of(follower));
        when(userRepository.findById(seller.getId())).thenReturn(Optional.of(seller));


        // Act
        userService.followUser(follower.getId(), seller.getId());

        // Assert
        assertTrue(follower.getFollowing().contains(seller.getId()));
        assertTrue(seller.getFollowers().contains(follower.getId()));

    }

    @Test
    @DisplayName("T-0001 US-0001 - Follow a seller - Cannot follow yourself test")
    void cannotFollowYourselfTest() {
        // Arrange
        int followerId = 1;
        int sellerId = 1;

        // Act and Assert
        assertThrows(
                BadRequestException.class,
                () -> userService.followUser(followerId, sellerId)
        );
    }

    @Test
    @DisplayName("T-0001 US-0001 - Follow a seller - Follower not found test")
    void followerNotFoundTest() {
        // Arrange
        int followerId = 1;
        int sellerId = 2;
        when(userRepository.findById(followerId)).thenReturn(Optional.empty());

        // Act and Arrange
        assertThrows(
                EntityNotFoundException.class,
                () -> userService.followUser(followerId, sellerId)
        );
    }

    @Test
    @DisplayName("T-0001 US-0001 - Follow a seller - Seller not found test")
    void sellerNotFoundTest() {
        // Arrange
        int followerId = 1;
        int sellerId = 2;
        when(userRepository.findById(followerId)).thenReturn(Optional.of(User.builder().build()));
        when(userRepository.findById(sellerId)).thenReturn(Optional.empty());

        // Act and Arrange
        assertThrows(
                EntityNotFoundException.class,
                () -> userService.followUser(followerId, sellerId)
        );
    }

    @Test
    @DisplayName("T-0001 US-0001 - Follow a seller - Already following test")
    void alreadyFollowingTest() {
        // Arrange
        User follower = User
                .builder()
                .name("Carlos")
                .following(new ArrayList<>())
                .id(1)
                .build();

        User seller = User
                .builder()
                .id(2)
                .name("Alfredo")
                .followers(List.of(follower.getId()))
                .isSeller(true)
                .build();

        when(userRepository.findById(follower.getId())).thenReturn(Optional.of(follower));
        when(userRepository.findById(seller.getId())).thenReturn(Optional.of(seller));

        // Act and Assert
        assertThrows(
                BadRequestException.class,
                () -> userService.followUser(follower.getId(), seller.getId())
        );


    }

    @Test
    @DisplayName("T-0002 US-0007 stop following success")
    public void deleteFollowedSeller() {
        Integer userIdA = 7000;
        Integer userIdB = 7001;

        User userA = new User(userIdA, "Daniel", false, null, null, List.of(userIdB));
        User userB = new User(userIdB, "Roberto", true, null, List.of(userIdA), null);

        when(userRepository.findById(userIdA)).thenReturn(Optional.of(userA));
        when(userRepository.findById(userIdB)).thenReturn(Optional.of(userB));
        when(userRepository.deleteFollowedSeller(userIdA, userIdB)).thenReturn(true);

        SuccessDTO successDTO = userService.deleteFollowedSeller(userIdA, userIdB);

        assertEquals(ResponseMessages.SUCCESS_USER_UNFOLLOWED.format(userIdB), successDTO.getMessage());
    }

    @Test
    @DisplayName("T-0002 US-0007 user to unfollow does not exist")
    public void deleteFollowedSellerEntityNotFoundException(){
        Integer userIdA = 7000;
        Integer userIdB = 7001;

        Optional<User> userA = Optional.of(new User(userIdA, "Daniel", false, null, null, List.of(userIdB)));

        when(userRepository.findById(userIdA)).thenReturn(userA);
        when(userRepository.findById(userIdB)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> userService.deleteFollowedSeller(userIdA, userIdB));
    }

    @Test
    @DisplayName("T-0002 US-0007 user to unfollow is not a seller")
    public void deleteFollowedSellerForbiddenException(){
        Integer userIdA = 7000;
        Integer userIdB = 7001;

        Optional<User> userA = Optional.of(new User(userIdA, "Daniel", false, null, null, List.of(userIdB)));
        Optional<User> userB = Optional.of(new User(userIdB, "Roberto", false, null, null, null));

        when(userRepository.findById(userIdA)).thenReturn(userA);
        when(userRepository.findById(userIdB)).thenReturn(userB);

        assertThrows(ForbiddenException.class, () -> userService.deleteFollowedSeller(userIdA, userIdB));
    }

    @Test
    @DisplayName("T-0002 US-0007 user to unfollow is not following")
    public void deleteFollowedSellerBadRequestException(){
        Integer userIdA = 7000;
        Integer userIdB = 7001;

        Optional<User> userA = Optional.of(new User(userIdA, "Daniel", false, null, List.of(7006), List.of(userIdB)));
        Optional<User> userB = Optional.of(new User(userIdB, "Roberto", true, null, List.of(7004,7005), null));

        when(userRepository.findById(userIdA)).thenReturn(userA);
        when(userRepository.findById(userIdB)).thenReturn(userB);

        assertThrows(BadRequestException.class, () -> userService.deleteFollowedSeller(userIdA, userIdB));
    }

    @Test
    @DisplayName("T-0002 US-0007 Same id")
    public void deleteFollowedSellerBadRequestExceptionSameId(){
        Integer userIdA = 7000;
        Integer userIdB = 7000;

        assertThrows(BadRequestException.class, () -> userService.deleteFollowedSeller(userIdA, userIdB));
    }


    @Test
    @DisplayName("T-0003 US-0008 search Follower List Order By NameDesc Happy Path")
    public void searchFollowerListOrderByNameDesc() {
        int userId = 1;
        String order = "NAME_DESC";
        when(userRepository.findSellerById(userId)).thenReturn(user);
        when(userRepository.findFollowersUsersList(userId, order)).thenReturn(followerList);
        assertDoesNotThrow(() -> userService.searchFollowerList(userId, order));
    }

    @Test
    @DisplayName("T-0003 US-0008 search Follower List Throw Bad Request Exception")
    public void searchFollowerListThrowBadRequestException() {
        int userId = 1;
        String order = "BAD_ORDER";
        when(userRepository.findSellerById(userId)).thenReturn(user);
        assertThrows(BadRequestException.class, () -> userService.searchFollowerList(userId, order));
    }

    @Test
    @DisplayName("US-0008 search Following List Order By NameDesc Happy Path")
    public void searchFollowedListOrderByNameDesc() {
        int userId = 1;
        String order = "NAME_DESC";
        when(userRepository.findById(userId)).thenReturn(user);
        when(userRepository.findFollowingUsersList(userId, order)).thenReturn(followdList);
        assertDoesNotThrow(() -> userService.searchFollowedList(userId, order));
    }

    @Test
    @DisplayName("US-0008 search Following List Throw Bad Request Exception")
    public void searchFollowedListThrowBadRequestException() {
        int userId = 1;
        String order = "BAD_ORDER";
        when(userRepository.findById(userId)).thenReturn(user);
        assertThrows(BadRequestException.class, () -> userService.searchFollowedList(userId, order));
    }

    @Test
    @DisplayName("T-0007 US-0002 number of followers. Happy Path")
    public void searchFollowersCount(){
        Integer userId = 7000;
        Optional<User> user = Optional.of(new User(userId, "Daniel", true, null, List.of(7001, 7002, 7003), null));

        when(userRepository.findById(userId)).thenReturn(user);
        when(userRepository.findFollowersCountById(userId)).thenReturn(3);

        Integer expected = userService.searchFollowersCount(userId).getFollowers_count();
        assertEquals(3, expected);
    }

    @Test
    @DisplayName("T-0007 US-0002 user not found")
    public void searchFollowersCountEntityNotFoundException(){
        Integer userId = 7000;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> userService.searchFollowersCount(userId));
    }

    @Test
    @DisplayName("T-0007 US-0002 user is not a seller")
    public void searchFollowersCountBadRequestException(){
        Integer userId = 7000;
        Optional<User> user = Optional.of(new User(userId, "Daniel", false, null, null, null));

        when(userRepository.findById(userId)).thenReturn(user);

        assertThrows(BadRequestException.class, () -> userService.searchFollowersCount(userId));
    }


    @Test
    @DisplayName("US-0008 search Follower List Throw Entity Not Found Exception")
    public void searchFollowerListThrowEntityNotFoundException() {
        int userId = 1;
        when(userRepository.findSellerById(userId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> userService.searchFollowerList(userId, anyString()));
    }




}
