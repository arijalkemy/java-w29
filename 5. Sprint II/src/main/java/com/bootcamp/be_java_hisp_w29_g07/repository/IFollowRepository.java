package com.bootcamp.be_java_hisp_w29_g07.repository;

import com.bootcamp.be_java_hisp_w29_g07.entity.Follow;
import com.bootcamp.be_java_hisp_w29_g07.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * This interface provides methods for managing follow relationships between users.
 */
public interface IFollowRepository {

    Follow saveFollow(User user, User userToFollow);
    List<Follow> findAll();
    Optional<Follow> findFollow(User user, User userToFollow);
    Long countByFollowedId(Integer userId);
    List<Follow> findFollowedByUserId(Integer userId);
    Integer deleteFollowUserById(Integer userId, Integer userIdToUnfollow);
    List<Follow> findFollowersByUserId(Integer userId);
    void deleteAll();
}
