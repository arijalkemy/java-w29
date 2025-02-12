package com.bootcamp.be_java_hisp_w29_g07.util;

import com.bootcamp.be_java_hisp_w29_g07.entity.Follow;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Factory class for creating {@link Follow} objects with predefined values.
 * This class is used to simplify the creation of {@link Follow} instances, particularly
 * in test scenarios where mock follow relationships are needed.
 */
public class UtilFollowFactory {

    /**
     * Creates a new instance of {@link Follow} with a predefined set of values.
     * This method establishes a "follow" relationship between two {@link User} objects.
     *
     * @param user the {@link User} who is following another user.
     * @param userToFollow the {@link User} who is being followed.
     * @return a {@link Follow} object representing the follow relationship between the two users.
     */
    public static Follow getFollow(User user, User userToFollow) {
        return new Follow(1, user, userToFollow, LocalDate.now());
    }

    /**
     * Generates a list of {@link Follow} objects for a given user, ordered by followed user's username in ascending order.
     *
     * @param user The user for whom the followed are generated.
     * @return A sorted list of {@link Follow} objects representing the user's followed.
     */
    public static List<Follow> getFollowedListOrderAsc(User user) {
        return Arrays.asList(
                new Follow(1, user, UtilUserFactory.getUser("cmorales", 2), LocalDate.now()),
                new Follow(2, user, UtilUserFactory.getUser("jfeo", 4), LocalDate.now())
        );
    }

    /**
     * Generates a list of {@link Follow} objects for a given user, ordered by followed user's username in descending order.
     *
     * @param user The user for whom the followed are generated.
     * @return A sorted list of {@link Follow} objects representing the user's followed.
     */
    public static List<Follow> getFollowedListOrderDesc(User user) {
        return Arrays.asList(
                new Follow(1, user, UtilUserFactory.getUser("jfeo", 4), LocalDate.now()),
                new Follow(2, user, UtilUserFactory.getUser("cmorales", 2), LocalDate.now())
        );
    }

    /**
     * Generates a list of {@link Follow} objects for a given user, ordered by followers user's username in ascending order.
     *
     * @param user The user for whom the followers are generated.
     * @return A sorted list of {@link Follow} objects representing the user's followers.
     */
    public static List<Follow> getFollowersListOrderAsc(User user) {
        return Arrays.asList(
                new Follow(2, UtilUserFactory.getUser("acano", 3), user, LocalDate.now()),
                new Follow(1, UtilUserFactory.getUser("alargo", 1), user, LocalDate.now()),
                new Follow(2, UtilUserFactory.getUser("bsanchez", 5), user, LocalDate.now())
        );
    }

    /**
     * Generates a list of {@link Follow} objects for a given user, ordered by followers user's username in descending order.
     *
     * @param user The user for whom the followers are generated.
     * @return A sorted list of {@link Follow} objects representing the user's followers.
     */
    public static List<Follow> getFollowersListOrderDesc(User user) {
        return Arrays.asList(
                new Follow(2, UtilUserFactory.getUser("bsanchez", 5), user, LocalDate.now()),
                new Follow(1, UtilUserFactory.getUser("alargo", 1), user, LocalDate.now()),
                new Follow(2, UtilUserFactory.getUser("acano", 3), user, LocalDate.now())
        );
    }
}
