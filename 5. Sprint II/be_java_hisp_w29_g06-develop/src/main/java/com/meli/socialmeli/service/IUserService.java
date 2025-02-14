package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.FollowedListResponseDto;
import com.meli.socialmeli.dto.UserDto;
import com.meli.socialmeli.dto.response.ResponseDto;

public interface IUserService {
    ResponseDto followSeller(Integer userId, Integer sellerId);
    FollowedListResponseDto getFollowedList(Integer userId, String order);
    ResponseDto unfollowSeller(Integer userId, Integer sellerId);
    UserDto add(UserDto userDto);
}
