package com.app.service;

import com.app.dto.response.*;

import java.util.List;

public interface IUserService {
    SuccessDTO followUser(int userId, int userIdToFollow);

    FollowedListDTO searchFollowedList(int userId, String order);

    FollowersCountDTO searchFollowersCount(int userId);

    SuccessDTO deleteFollowedSeller(int userId, int userIdToUnfollow);

    FollowerListDTO searchFollowerList(int userId, String order);

    List<UserDTO> searchAll();
}
