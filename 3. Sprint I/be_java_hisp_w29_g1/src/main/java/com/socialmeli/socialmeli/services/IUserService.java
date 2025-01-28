package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.dto.response.*;
import com.socialmeli.socialmeli.dto.response.FollowerListDto;

public interface IUserService {
    MessageDto follow(Integer follower, Integer UserToFollow);

    MessageDto unfollow(Integer userId, Integer userIdToUnfollow);

    UserFollowerCountDto countFollowers(Integer id);

    FollowerListDto getFollowerList(Integer userId, String order);

    FollowedListDto getFollowedList(Integer userId, String order);

    TopSellersDto getTopSellers();
}
