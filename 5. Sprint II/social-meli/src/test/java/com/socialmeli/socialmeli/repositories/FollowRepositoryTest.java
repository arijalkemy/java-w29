package com.socialmeli.socialmeli.repositories;

import com.socialmeli.socialmeli.models.Follow;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.utils.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FollowRepositoryTest {

    private FollowRepository followRepository;

    @BeforeEach
    void setUp() throws IOException {
        followRepository = new FollowRepository();
        followRepository.loadDataBase();
    }

    @Test
    @DisplayName("#42 findAllByIdFollower - should return a list of follows by id follower")
    void findAllByIdFollowerTest_whenSuccess_thenReturnListFollow() {
        // Arrange
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        User user3 = UserFactory.createSeller(3, "Ciro Sánchez");
        User user4 = UserFactory.createBuyer(4, "Eliana Navarro");

        List<Follow> expected = List.of(new Follow(user4, user3), new Follow(user4, user1));

        // Act
        List<Follow> result = followRepository.findAllByIdFollower(user4.getId());

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("#43 deleteTest - should remove the follow relationship from the repository")
    void deleteTest() {
        // Arrange
        User user1 = new User(1, "Emilia Mernes", false);
        User user2 = new User(2, "Taylor Swift", true);
        Follow follow = new Follow(user1, user2);
        followRepository.add(follow);

        // Act
        followRepository.delete(follow);

        // Assert
        assertFalse(followRepository.exists(follow));
    }

    @Test
    @DisplayName("#44 findFollowedUsersTest - should return a list of user that one user follows")
    void  findFollowedUsersTest_whenUserFollowsSellers_thenReturnListOfFollowedUsers() {
        // Arrange
        User user1 = new User(1, "Agostina Avalle", true);
        List<User> expected = List.of(
                new User(3, "Ciro Sánchez", true)
        );

        // Act
        List<User> result = followRepository.findFollowedUsers(user1);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("#45 findAllByIdFollowed - should return a list of follows by id follower")
    void findAllByIdFollowedTest_thenReturnListFollows() {
        //Arrange
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        User user2 = UserFactory.createBuyer(2, "Carolina Comba");
        User user4 = UserFactory.createBuyer(4, "Eliana Navarro");
        User user6 = UserFactory.createBuyer(6, "Katerinne Peralta");
        List<Follow> expected =  List.of(
                new Follow(user2, user1),
                new Follow(user4, user1),
                new Follow(user6, user1)
        );

        //Act
        List<Follow> result = followRepository.findAllByIdFollowed(user1.getId());

        //Assertions
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("#46 exists - should return true when follow exists")
    void existsTest_whenFollowExists_thenReturnTrue() {
        // Arrange
        User user1 = UserFactory.createBuyer(2, "Carolina Comba");
        User user2 = UserFactory.createSeller(1, "Agostina Avalle");
        Follow follow = new Follow(user1, user2);

        // Act
        boolean result = followRepository.exists(follow);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("#47 exists - should return false when follow doesnt exists")
    void existsTest_whenFollowDoesntExists_thenReturnFalse() {
        // Arrange
        User user1 = UserFactory.createBuyer(2, "Carolina Comba");
        User user2 = UserFactory.createSeller(1, "Agostina Avalle");
        Follow follow = new Follow(user2, user1);

        // Act
        boolean result = followRepository.exists(follow);

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("#48 add - should add a follow to the list")
    void addTest_whenAdd_thenVoid() {
        // Arrange
        User user1 = UserFactory.createSeller(1, "Agostina Avalle");
        User user5 = UserFactory.createSeller(5, "Franca Pairetti");
        Follow follow = new Follow(user1, user5);

        // Act
        followRepository.add(follow);

        // Assert
        assertTrue(followRepository.getFollows().contains(follow));
    }
}
