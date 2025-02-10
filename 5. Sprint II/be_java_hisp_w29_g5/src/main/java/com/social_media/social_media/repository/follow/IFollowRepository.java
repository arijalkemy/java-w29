package com.social_media.social_media.repository.follow;

import com.social_media.social_media.entity.Follow;
import java.util.List;

import java.util.Optional;

public interface IFollowRepository {

    List<Follow> findFollowed(Long userId);

    Follow addFollow(Long followerId, Long followedId);

    List<Follow> findFollowers(Long followedId);

    Optional<Follow> existsByFollowerAndFollowed(Long userId, Long userIdToFollow);

    void deleteFollow(Follow followToDelete);
}
