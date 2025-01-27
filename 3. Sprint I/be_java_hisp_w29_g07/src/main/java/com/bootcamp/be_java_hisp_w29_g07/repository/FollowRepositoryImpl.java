package com.bootcamp.be_java_hisp_w29_g07.repository;

import com.bootcamp.be_java_hisp_w29_g07.entity.Follow;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class is an implementation of the IPostRepository interface.
 * It provides concrete methods for interacting with the data store to manage posts.
 */
@Repository
public class FollowRepositoryImpl implements IFollowRepository {
    /**
     * The Follow list.
     */
    private final List<Follow> followList = new ArrayList<>();

    /**
     * Creates a new Follow instance representing a user following another user.
     * @param user         the user who is following
     * @param userToFollow the user to be followed
     * @return the created Follow instance
     */
    @Override
    public Follow saveFollow(User user, User userToFollow) {
        Follow follow = new Follow((this.followList.size() + 1), user, userToFollow, LocalDate.now());
        followList.add(follow);
        return follow;
    }

    /**
     * Retrieves all the follow relationships stored in the repository.
     * @return a list of all Follow instances
     */
    @Override
    public List<Follow> findAll() {
        return followList;
    }

    /**
     * Searches for a specific follow relationship between two users.
     * @param user         the user who may have followed another user
     * @param userToFollow the user who may be followed
     * @return an Optional containing the Follow instance if exists, otherwise empty
     */
    @Override
    public Optional<Follow> findFollow(User user, User userToFollow) {
        return findAll()
                .stream()
                .filter(follow -> follow.getFollower().getId().equals(user.getId()))
                .filter(follow -> follow.getFollowed().getId().equals(userToFollow.getId()))
                .findFirst();
    }

    /**
     *Counts how many users are being followed by a specific user
     * identified by their user ID.
     * @param userId the user id of the user being followed
     * @return the count of Follow instances for the specified userId
     */
    @Override
    public Long countByFollowedId(Integer userId) {
        return this.followList.stream()
                .filter(f -> f.getFollowed().getId().equals(userId))
                .count();
    }

    /**
     * Retrieves a list of Follow instances where the specified user
     * is the follower.
     * @param userId the user id of the follower
     * @return a list of Follow instances for the specified userId
     */
    @Override
    public List<Follow> findFollowedByUserId(Integer userId) {
        return this.followList
                .stream()
                .filter(follow -> follow.getFollower().getId().equals(userId))
                .toList();
    }

    /**
     * Retrieves a list of Follow instances where the specified user
     * is being followed.
     * @param userId the user id of the followed user
     * @return a list of Follow instances for the specified userId
     */
    @Override
    public List<Follow> findFollowersByUserId(Integer userId) {
        return this.followList
                .stream()
                .filter(follow -> follow.getFollowed().getId().equals(userId))
                .toList();
    }

    /**
     *Attempts to delete a follow relationship between a user and another user.
     * @param userId           the user id of the follower
     * @param userIdToUnfollow the user id of the user to unfollow
     * @return true if the follow relationship was deleted, otherwise false
     */
    @Override
    public Boolean deleteFollowUserById(Integer userId, Integer userIdToUnfollow) {
        Optional<Follow> optionalFollow = followList.stream()
                .filter(
                        f -> f.getFollower().getId().equals(userId)
                                && f.getFollowed().getId().equals(userIdToUnfollow))
                .findFirst();

        if (optionalFollow.isEmpty()) {
            return false;
        }

        followList.remove(optionalFollow.get());
        return true;
    }

}
