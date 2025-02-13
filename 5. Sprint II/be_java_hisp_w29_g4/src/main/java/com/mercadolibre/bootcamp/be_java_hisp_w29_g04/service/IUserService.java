package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.service;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.MessageDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.UserDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.*;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowingDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowersDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.UserOrderTypeEnum;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();
    UserDto save(UserDto user);
    UserDto update(UserDto user);
    boolean delete(Integer id);
    UserDto findDtoById(Integer id);
    User findById(Integer id);

    MessageDto follow(Integer userId, Integer userIdToFollow);
    MessageDto unfollow(Integer userId, Integer userIdToUnfollow);
    FollowersDto getUsersBySeller(Integer userId, String orderType);
    FollowingDto getSellersByUser(Integer userId, String orderType);
    MessageDto followSeller(Integer userId, Integer userIdToFollow);
    MessageDto unfollowSeller(Integer userId, Integer userIdToUnfollow);
    FollowersCountDto getFollowersCount(Integer userId);
    UserOrderTypeEnum isOrderTypeValid(String orderType);
}
