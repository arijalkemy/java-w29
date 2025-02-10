package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.dto.response.MessageDto;
import com.socialmeli.socialmeli.dto.response.UserFollowerCountDto;
import com.socialmeli.socialmeli.dto.response.FollowerListDto;
import com.socialmeli.socialmeli.dto.response.FollowedListDto;

public interface IUserService {
    MessageDto follow(Integer follower, Integer userToFollow);

    MessageDto unfollow(Integer userId, Integer userIdToUnfollow);

    UserFollowerCountDto countFollowers(Integer id);

    FollowerListDto getFollowerList(Integer userId, String order);

    FollowedListDto getFollowedList(Integer userId, String order);
}
