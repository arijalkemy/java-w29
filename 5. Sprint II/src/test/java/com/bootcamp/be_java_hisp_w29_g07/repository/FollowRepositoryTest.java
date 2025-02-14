package com.bootcamp.be_java_hisp_w29_g07.repository;

import com.bootcamp.be_java_hisp_w29_g07.entity.Follow;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilFollowFactory;
import com.bootcamp.be_java_hisp_w29_g07.util.UtilUserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Unit test class for {@link FollowRepositoryImpl}.
 */
class FollowRepositoryTest {

    /**
     * Instance of {@link IFollowRepository} that is being tested.
     * It is initialized with a concrete implementation before each test.
     */
    private IFollowRepository followRepository;

    /**
     * Set up the test environment before each test method is run.
     * Initializes the {@link IFollowRepository} with its concrete implementation {@link FollowRepositoryImpl}.
     * This ensures that a fresh instance is created for each test.
     *
     */
    @BeforeEach
    public void setUp() {
        this.followRepository = new FollowRepositoryImpl();
    }

    /**
     * Unit Test to verify that when a user attempts to follow another user,
     * the follow relationship is successfully created and added to the follow list.
     * The method checks that the returned follow object has the correct follower and followed users,
     * and that the follow has a valid ID.
     */
    @Test
    void givenUserAndUserToFollow_whenSaveFollow_thenReturnFollow() {
        User user = mock(User.class);
        User userToFollow = mock(User.class);
        Follow response = followRepository.saveFollow(user, userToFollow);
        assertEquals(user, response.getFollower());
        assertEquals(userToFollow, response.getFollowed());
        assertEquals(1, response.getId());
    }

    @Test
    void findAll() {
    }

    @Test
    void findFollow() {
    }

    @Test
    void countByFollowedId() {
    }

    @Test
    void findFollowedByUserId() {
    }

    /**
     * Unit Test to verify that when a user has existing followers,
     * calling findFollowersByUserId returns a list of follows.
     * The test ensures that the followers are correctly returned for a specific user.
     *
     * In this case, two users (user1 and user3) follow user2. The test will check
     * if the followers of user2 are returned correctly, ensuring the relationship
     * is stored and fetched properly from the repository.
     */
    @Test
    void givenExistingFollowers_whenFindFollowersByUserId_thenReturnListOfFollows() {
        User user1 = UtilUserFactory.getUser("alargo", 1);
        User user2 = UtilUserFactory.getUser("jfeo", 2);
        User user3 = UtilUserFactory.getUser("bcamilo", 3);

        followRepository.saveFollow(user1, user2);
        followRepository.saveFollow(user3, user2);

        List<Follow> followedList = followRepository.findFollowersByUserId(user2.getId());

        Follow expectedFollowUser1 = UtilFollowFactory.getFollow(user1, user2);
        Follow expectedFollowUser3 = UtilFollowFactory.getFollow(user3, user2);
        expectedFollowUser3.setId(2);

        List<Follow> expectedFollowList = Arrays.asList(expectedFollowUser1,expectedFollowUser3);

        Assertions.assertEquals(2, followedList.size());
        Assertions.assertArrayEquals(expectedFollowList.toArray(), followedList.toArray());
    }

    /**
     * Unit Test to verify that when a user with no followers calls
     * findFollowedByUserId, the operation returns an empty list.
     */
    @Test
    void givenNoExistingFollowers_whenFindFollowersByUserId_thenReturnListEmpty() {
        User user1 = UtilUserFactory.getUser("jfeo", 1);

        List<Follow> followedList = followRepository.findFollowedByUserId(user1.getId());

        Assertions.assertEquals(0, followedList.size());
    }

    /**
     * Unit Test to verify that when a follow relationship exists between two users,
     * deleting the follow by user ID returns 1 and the follow no longer exists.
     */
    @Test
    void givenExistingFollow_whenDeleteFollowUserById_thenReturnOne() {
        User userFollower = UtilUserFactory.getUser("alargo", 6);
        User userFollowed = UtilUserFactory.getUser("jfeo", 7);
        followRepository.saveFollow(userFollower, userFollowed);

        Integer numberOfFollowsDeleted = followRepository.deleteFollowUserById(userFollower.getId(), userFollowed.getId());

        Assertions.assertEquals(1, numberOfFollowsDeleted);
        Assertions.assertTrue(followRepository.findFollow(userFollower, userFollowed).isEmpty());
    }

    /**
     * Unit Test to verify that when no follow relationship exists between two id users,
     * using one existing user ID and one non-existent user ID, the operation
     * returns 0, indicating no follow was deleted.
     */
    @Test
    void givenNonExistentFollowByOneExistentId_whenDeleteFollowUserById_thenReturnZero() {
        User userFollower = UtilUserFactory.getUser("alargo", 6);
        User userFollowed = UtilUserFactory.getUser("jfeo", 7);
        followRepository.saveFollow(userFollower, userFollowed);

        Integer numberOfFollowsDeleted = followRepository.deleteFollowUserById(9, userFollowed.getId());

        Assertions.assertEquals(0, numberOfFollowsDeleted);
    }

    /**
     * Unit Test to verify that when no follow relationship exists between two id users,
     * attempting to delete the follow by user ID returns 0.
     */
    @Test
    void givenNonExistentFollow_whenDeleteFollowUserById_thenReturnZero() {
        Integer numberOfFollowsDeleted = followRepository.deleteFollowUserById(6, 7);

        assertEquals(0, numberOfFollowsDeleted);
    }

    /**
     * Unit Test to verify that counting followers for a user with followers returns the correct count.
     * <p>
     * This test creates a seller and two followers, saving the follow relationships.
     * It then retrieves the follower count and verifies that it matches the expected value.
     * </p>
     */
    @Test
    void givenUserWithFollowers_whenCountByFollowedId_thenReturnCorrectFollowersCount() {
        User userFollower1 = UtilUserFactory.getUser("user1", 1);
        User userFollower2 = UtilUserFactory.getUser("user2", 2);
        User seller = UtilUserFactory.getSeller(5);
        followRepository.saveFollow(userFollower1, seller);
        followRepository.saveFollow(userFollower2, seller);

        Long followersCountResult = followRepository.countByFollowedId(seller.getId());

        assertEquals(2L, followersCountResult);
    }

    /**
     * Unit Test to verify that counting followers for a user with no followers returns zero.
     * <p>
     * This test creates a seller with no followers and retrieves the follower count.
     * It verifies that the response correctly returns zero.
     * </p>
     */
    @Test
    void givenUserWithNoFollowers_whenCountByFollowedId_thenReturnZeroCount() {
        User seller = UtilUserFactory.getSeller(5);

        Long followersCountResult = followRepository.countByFollowedId(seller.getId());

        assertEquals(0L, followersCountResult);
    }


    /**
     * Unit Test to verify that when a user has followers, the method
     * findFollowedByUserId returns the correct list of follows for that user.
     */
    @Test
    void givenExistingFollowers_whenFindFollowedByUserId_thenReturnListOfFollows() {
        User user1 = UtilUserFactory.getUser("alargo", 1);
        User user2 = UtilUserFactory.getUser("jfeo", 2);
        User user3 = UtilUserFactory.getUser("bcamilo", 3);

        followRepository.saveFollow(user1, user2);
        followRepository.saveFollow(user1, user3);

        List<Follow> followedList = followRepository.findFollowedByUserId(user1.getId());

        Follow expectedFollowUser1 = UtilFollowFactory.getFollow(user1, user2);
        Follow expectedFollowUser2 = UtilFollowFactory.getFollow(user1, user3);
        expectedFollowUser2.setId(2);

        List<Follow> expectedFollowList = Arrays.asList(expectedFollowUser1,expectedFollowUser2);

        Assertions.assertEquals(2, followedList.size());
        Assertions.assertArrayEquals(expectedFollowList.toArray() ,followedList.toArray());
    }

    /**
     * Unit Test to verify that when a user with no followers calls
     * findFollowedByUserId, the operation returns an empty list.
     */
    @Test
    void givenNoExistingFollowers_whenFindFollowedByUserId_thenReturnListOfFollows() {
        User user1 = UtilUserFactory.getUser("jfeo", 1);

        List<Follow> followedList = followRepository.findFollowedByUserId(user1.getId());

        Assertions.assertEquals(0, followedList.size());
    }


}